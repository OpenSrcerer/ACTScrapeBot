package actScrapeBot.requests;

import actScrapeBot.entities.ActUser;

import java.util.concurrent.ScheduledFuture;

public interface Request {

    ActUser getRequestUser();

    void setLifetime(ScheduledFuture<?> lifetime);

    void cancelDestruction();

    void queue();
}
