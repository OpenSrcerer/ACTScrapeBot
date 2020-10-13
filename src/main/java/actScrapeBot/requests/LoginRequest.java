package actScrapeBot.requests;

import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.RequestManager;

import java.util.concurrent.ScheduledFuture;

public class LoginRequest implements Request {

    private final ActUser requestUser;
    private ScheduledFuture<?> lifetime;

    public LoginRequest(ActUser rUser) {
        requestUser = rUser;
        queue();
    }

    @Override
    public ActUser getRequestUser() {
        return requestUser;
    }

    @Override
    public void setLifetime(ScheduledFuture<?> lt) {
        lifetime = lt;
    }

    @Override
    public void cancelDestruction() {
        lifetime.cancel(false);
    }

    @Override
    public void queue() {
        RequestManager.getInstance().queueRequest(this);
    }
}
