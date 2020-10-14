package actScrapeBot.commands.logout;

import actScrapeBot.ScrapeBot;
import actScrapeBot.callables.LogoutCallable;
import actScrapeBot.commands.Command;
import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.UserManager;
import actScrapeBot.preparedStatements.HelpEmbeds;
import actScrapeBot.requests.LogoutRequest;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;

/**
 * Initiates a logout request.
 */
public class Logout implements Command {

    private final User eventUser;
    private PrivateChannel eventChannel;

    /**
     * Initiates a Logout request. Notice the logic in the constructor.
     * If the command was executed from the server, the bot responds
     * through a private channel to keep login details private.
     * If the private channel does not exist, it creates a new one.
     * @param eu User that called event.
     * @param pc Channel where message was sent. (Could be TextChannel or PrivateChannel)
     */
    public Logout(User eu, MessageChannel pc) {
        eventUser = eu;

        if (!(pc instanceof PrivateChannel)) {
            PrivateChannel tempChannel = ScrapeBot.ScrapeBot.getPrivateChannelById(eu.getId());

            if (tempChannel == null) {
                ScrapeBot.ScrapeBot.openPrivateChannelById(eu.getId())
                        .map(this::execWithNewPrivChannel)
                        .queue();
            }
        } else {
            eventChannel = (PrivateChannel) pc;
            execute();
        }
    }

    private PrivateChannel execWithNewPrivChannel(PrivateChannel pc) {
        eventChannel = pc;
        execute();
        return pc;
    }

    @Override
    public void execute() {
        ActUser user = UserManager.getInstance().getLoggedInUser(eventUser.getId());

        if (user.getActUsername().equals("")) {
            eventChannel.sendMessage(HelpEmbeds.helpNotLoggedIn().build()).queue();
            return;
        }

        new LogoutRequest(new LogoutCallable(eventChannel, user));
    }
}
