package actScrapeBot.commands.logout;

import actScrapeBot.commands.ListenerType;
import actScrapeBot.entities.ActUser;
import actScrapeBot.listeners.RequestListener;
import actScrapeBot.preparedStatements.ReturnEmbeds;
import actScrapeBot.requests.Request;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * Listener that processes and sends a message in
 * the respective Discord channel whenever a request
 * of its' expected type is complete.
 */
public class LogoutReceiver implements RequestListener {

    @Override
    public void requestComplete(Object result, MessageChannel channel) {
        ActUser user = (ActUser) result;

        channel.sendMessage(ReturnEmbeds.returnLogoutSuccessful(user.getActUsername()).build()).queue();
    }

    @Override
    public void requestFailed(Request request, MessageChannel channel) {

    }

    @Override
    public ListenerType getType() {
        return ListenerType.LOGOUT;
    }
}
