package actScrapeBot.listeners;

import actScrapeBot.requests.Request;

public interface RequestListener {

    void requestComplete(Request request);

    void requestFailed(Request request);
}
