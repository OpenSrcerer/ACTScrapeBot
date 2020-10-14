package actScrapeBot.callables;

import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * Interface designed to manage code, which
 * executes only in relation to retrieving
 * information from the WebClient.
 */
public interface RequestCallable {
    MessageChannel getChannel();
}
