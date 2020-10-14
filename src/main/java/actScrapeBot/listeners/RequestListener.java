package actScrapeBot.listeners;

import actScrapeBot.commands.ListenerType;
import actScrapeBot.requests.Request;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * Manages other RequestListeners. The purpose of this
 * interface is whenever a request gets consumed by the
 * RequestManager and returns a result, the value gets passed
 * to other interested listeners. Hereby, they are all combined
 * in an interface.
 */
public interface RequestListener {

    void requestComplete(Object result, MessageChannel channel);

    void requestFailed(Request request, MessageChannel channel);

    ListenerType getType();
}
