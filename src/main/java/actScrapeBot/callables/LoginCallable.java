package actScrapeBot.callables;

import actScrapeBot.entities.ActUser;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.concurrent.Callable;

/**
 * WebClient Code to run when Login is called.
 */
public class LoginCallable implements RequestCallable, Callable<ActUser> {

    private final MessageChannel requestChannel;
    private final String discordId, username, password;

    public LoginCallable(MessageChannel rChannel, String dId, String rUser, String rPass) {
        requestChannel = rChannel;
        discordId = dId;
        username = rUser;
        password = rPass;
    }

    @Override
    public ActUser call() {
        // code to get login
        return null;
    }

    @Override
    public MessageChannel getChannel() {
        return requestChannel;
    }
}
