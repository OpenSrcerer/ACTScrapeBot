package actScrapeBot.managers;

import actScrapeBot.listeners.RequestListener;
import actScrapeBot.requests.LoginRequest;
import actScrapeBot.requests.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RequestManager {

    protected static final RequestManager instance = new RequestManager();
    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private static final ArrayList<Request> requests = new ArrayList<>();
    private static final ArrayList<RequestListener> listeners = new ArrayList<>();

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
    public void queueRequest(Request request) {
        requests.add(request);
        expungeRequest(request);
    }

    /**
     * Removes request from array of active requests immediately.
     * @param request Request to be removed.
     */
    public void expungeRequestNow(Request request) {
        requests.remove(request);
        request.cancelDestruction();
    }

    /**
     * Schedule request to be expunged from the array.
     * @param request Request to be removed.
     */
    public void expungeRequest(Request request) {
        Runnable removeRequest = () -> requests.remove(request);

        if (request instanceof LoginRequest) {
            request.setLifetime(executor.schedule(removeRequest, 30, TimeUnit.SECONDS));
        }
    }
}
