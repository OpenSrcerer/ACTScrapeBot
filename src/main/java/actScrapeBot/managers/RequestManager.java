package actScrapeBot.managers;

import actScrapeBot.commands.ListenerType;
import actScrapeBot.listeners.RequestListener;
import actScrapeBot.requests.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class RequestManager {

    private static final int nThreads = 5;

    private static final Logger lgr = LoggerFactory.getLogger(RequestManager.class);
    protected static final RequestManager instance = new RequestManager();
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);
    private static final LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>(nThreads);
    private static final List<RequestListener> listeners = new ArrayList<>();

    static {
        Runnable runRequests = () -> {
            while (true) {
                Request request = null;

                try {
                    request = requests.take();
                } catch (InterruptedException ex) {
                    lgr.warn("Thread interrupted while waiting for request.", ex);
                }

                if (request == null) {
                    return;
                }

                request.run();
                ListenerType listenerType = null;

                if (request instanceof LoginRequest) {
                    listenerType = ListenerType.LOGIN;
                } else if (request instanceof LogoutRequest) {
                    listenerType = ListenerType.LOGOUT;
                } else if (request instanceof CoursesRequest) {
                    listenerType = ListenerType.COURSES;
                } else if (request instanceof ResourcesRequest) {
                    listenerType = ListenerType.RESOURCES;
                }

                lgr.debug("Handling request of type " + listenerType);

                for (RequestListener listener : listeners) {
                    if (listener.getType().equals(listenerType)) {
                        listener.requestComplete(request.getValue(), request.getCallable().getChannel());
                    }
                }
            }
        };

        for (int thread = 1; thread <= nThreads; ++thread) {
            executor.submit(runRequests);
        }
    }

    public static RequestManager getInstance() {
        return instance;
    }

    /**
     * Adds the listeners to the listeners array of active listeners.
     * @param listener Listeners to be added.
     */
    public void addListener(RequestListener... listener) {
        listeners.addAll(Arrays.asList(listener));
    }

    /**
     * Adds the request to the requests array of active requests.
     * @param request Request to be added.
     */
    public void queueRequest(Request request) throws InterruptedException {
        requests.put(request);
    }
}
