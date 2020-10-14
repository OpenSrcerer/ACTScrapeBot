package actScrapeBot.requests;

import actScrapeBot.callables.LogoutCallable;
import actScrapeBot.callables.RequestCallable;
import actScrapeBot.managers.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Request that contains necessary details for
 * users to be logged out.
 */
public class LogoutRequest implements Request {

    private final LogoutCallable callable;
    private static final Logger lgr = LoggerFactory.getLogger(LogoutRequest.class);

    // Return item
    private boolean logoutSuccessful = false;

    public LogoutRequest(LogoutCallable cllbl) {
        callable = cllbl;
        queue();
    }

    @Override
    public void queue() {
        try {
        RequestManager.getInstance().queueRequest(this);
        } catch (InterruptedException ex) {
            lgr.warn("Thread interrupted while queuing request!");
        }
    }

    @Override
    public void run() {
        logoutSuccessful = callable.call();
    }

    @Override
    public Boolean getValue() {
        return logoutSuccessful;
    }

    @Override
    public RequestCallable getCallable() {
        return callable;
    }
}
