package actScrapeBot.requests;

import actScrapeBot.callables.RequestCallable;

/**
 * This interface's purpose is managing
 * different types of Requests that need to
 * be processed, in an easier fashion.
 */
public interface Request {
    void queue();

    void run();

    Object getValue();

    RequestCallable getCallable();
}
