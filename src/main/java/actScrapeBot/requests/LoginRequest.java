package actScrapeBot.requests;

import actScrapeBot.callables.LoginCallable;
import actScrapeBot.callables.RequestCallable;
import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Request that contains necessary details for
 * users to be logged in.
 */
public class LoginRequest implements Request {

    private final LoginCallable callable;
    private static final Logger lgr = LoggerFactory.getLogger(LoginRequest.class);

    private ActUser user = new ActUser();

    public LoginRequest(LoginCallable cllbl) {
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
        user = callable.call();
    }

    @Override
    public ActUser getValue() {
        return user;
    }

    @Override
    public RequestCallable getCallable() {
        return callable;
    }
}
