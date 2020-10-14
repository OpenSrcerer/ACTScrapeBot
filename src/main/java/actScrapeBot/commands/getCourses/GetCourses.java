package actScrapeBot.commands.getCourses;

import actScrapeBot.ScrapeBot;
import actScrapeBot.callables.CoursesCallable;
import actScrapeBot.commands.Command;
import actScrapeBot.entities.ActUser;
import actScrapeBot.managers.UserManager;
import actScrapeBot.preparedStatements.HelpEmbeds;
import actScrapeBot.requests.CoursesRequest;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

/**
 * Initiates a GetCourses request.
 */
public class GetCourses implements Command {
    private final User eventUser;
    private PrivateChannel eventChannel;
    private final List<String> args;

    /**
     * Initiates a GetCourses request. Notice the logic in the constructor.
     * If the command was executed from the server, the bot responds
     * through a private channel to keep login details private.
     * If the private channel does not exist, it creates a new one.
     * @param eu User that called event.
     * @param pc Channel where message was sent. (Could be TextChannel or PrivateChannel)
     * @param ar Argument list.
     */
    public GetCourses(User eu, MessageChannel pc, List<String> ar) {
        eventUser = eu;
        args = ar;

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
        if (args.isEmpty()) {
            eventChannel.sendMessage(HelpEmbeds.helpLogin().build()).queue();
            return;
        }

        ActUser user = UserManager.getInstance().getLoggedInUser(eventUser.getId());

        if (user.isAnonymous()) {
            eventChannel.sendMessage(HelpEmbeds.helpPleaseLogin().build()).queue();
            return;
        }

        String courseName = args.get(0);

        new CoursesRequest(new CoursesCallable(eventChannel, user, courseName));
    }
}
