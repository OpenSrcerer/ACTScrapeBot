package actScrapeBot.callables;

import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.UserManager;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.concurrent.Callable;

/**
 * Code to run when Logout is called.
 */
public class LogoutCallable implements RequestCallable, Callable<Boolean> {

    private final MessageChannel requestChannel;
    private final ActUser requestUser;

    public LogoutCallable(MessageChannel rChannel, ActUser rUser) {
        requestChannel = rChannel;
        requestUser = rUser;
    }

    @Override
    public Boolean call() {
        UserManager.getInstance().removeLoggedInUser(requestUser);
        return true;
    }

    @Override
    public MessageChannel getChannel() {
        return requestChannel;
    }
}
