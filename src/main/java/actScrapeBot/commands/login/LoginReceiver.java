package actScrapeBot.commands.login;

import actScrapeBot.commands.ListenerType;
import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.UserManager;
import actScrapeBot.preparedStatements.ErrorEmbeds;
import actScrapeBot.preparedStatements.HelpEmbeds;
import actScrapeBot.requests.Request;
import actScrapeBot.listeners.RequestListener;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * Listener that processes and sends a message in
 * the respective Discord channel whenever a request
 * of its' expected type is complete.
 */
public class LoginReceiver implements RequestListener {

    @Override
    public void requestComplete(Object result, MessageChannel channel) {
        ActUser user = (ActUser) result;
        if (!user.isAnonymous()) {
            UserManager.getInstance().addLoggedInUser(user);
            channel.sendMessage(HelpEmbeds.helpAlreadyLoggedIn(user.getActUsername()).build()).queue();
        } else {
            channel.sendMessage(ErrorEmbeds.errorLogin().build()).queue();
        }
    }

    @Override
    public void requestFailed(Request request, MessageChannel channel) {

    }

    @Override
    public ListenerType getType() {
        return ListenerType.LOGIN;
    }
}
