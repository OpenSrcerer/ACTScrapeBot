package actScrapeBot.commands.login;

import actScrapeBot.ScrapeBot;
import actScrapeBot.commands.Command;
import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.UserManager;
import actScrapeBot.preparedStatements.ErrorEmbeds;
import actScrapeBot.preparedStatements.HelpEmbeds;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class Login implements Command {

    private final User eventUser;
    private PrivateChannel eventChannel;
    private final List<String> args;

    /**
     * Initiates a Login event. Notice the logic in the constructor.
     * If the command was executed from the server, the bot responds
     * through a private channel to keep login details private.
     * If the private channel does not exist, it creates a new one.
     * @param eu User that called event.
     * @param pc Channel where message was sent. (Could be TextChannel or PrivateChannel)
     * @param ar Argument list.
     */
    public Login(User eu, MessageChannel pc, List<String> ar) {
        eventUser = eu;
        args = ar;

        if (pc instanceof TextChannel) {
            PrivateChannel tempChannel = ScrapeBot.ScrapeBot.getPrivateChannelById(eu.getId());

            if (tempChannel == null) {
                ScrapeBot.ScrapeBot.openPrivateChannelById(eu.getId())
                        .map(this::setPrivateChannel)
                        .queue();
            }
        } else {
            eventChannel = (PrivateChannel) pc;
        }

        execute();
    }

    private PrivateChannel setPrivateChannel(PrivateChannel pc) {
        eventChannel = pc;
        return pc;
    }

    @Override
    public void execute() {
        if (args.isEmpty()) {
            eventChannel.sendMessage(HelpEmbeds.helpLogin().build()).queue();
            return;
        }

        ActUser user = UserManager.getInstance().getLoggedInUser(eventUser.getId());

        if (user.getActUsername() != null) {
            eventChannel.sendMessage(HelpEmbeds.helpAlreadyLoggedIn(user.getActUsername()).build()).queue();
            return;
        }

        String username = args.get(0), password = args.get(1);

        // log in using webclient

        if (login successful) {
            UserManager.getInstance().addLoggedInUser(user);
            eventChannel.sendMessage(HelpEmbeds.helpAlreadyLoggedIn(user.getActUsername()).build()).queue();
        } else {
            eventChannel.sendMessage(ErrorEmbeds.errorLogin().build()).queue();
        }
    }
}
