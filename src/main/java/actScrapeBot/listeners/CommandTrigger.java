package actScrapeBot.listeners;

import actScrapeBot.ScrapeBot;
import actScrapeBot.commands.getCourses.GetCourses;
import actScrapeBot.commands.getResources.GetResources;
import actScrapeBot.commands.login.Login;
import actScrapeBot.commands.logout.Logout;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;


@SuppressWarnings("DuplicatedCode")
public class CommandTrigger extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMember() == null)
            return;

        if (event.getMember().getUser().isBot())
            return;

        ArrayList<String> args = getArguments(event.getMessage());

        if (args.size() < 2) { return; }

        if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("login")) {
            args.subList(0, 2).clear();
            new Login(event.getAuthor(), event.getChannel(), args);
        }

        else if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("logout")) {
            args.subList(0, 2).clear();
            new Logout(event.getAuthor(), event.getChannel());
        }

        else if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("getcourses")) {
            args.subList(0, 2).clear();
            new GetCourses(event.getAuthor(), event.getChannel(), args);
        }

        else if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("getresources")) {
            args.subList(0, 2).clear();
            new GetResources(event.getAuthor(), event.getChannel(), args);
        }
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;

        ArrayList<String> args = getArguments(event.getMessage());

        if (args.size() < 2) { return; }

        if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("login")) {
            args.subList(0, 2).clear();
            new Login(event.getAuthor(), event.getChannel(), args);
        }

        else if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("logout")) {
            args.subList(0, 2).clear();
            new Logout(event.getAuthor(), event.getChannel());
        }

        else if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("getcourses")) {
            args.subList(0, 2).clear();
            new GetCourses(event.getAuthor(), event.getChannel(), args);
        }

        else if (args.get(0).equalsIgnoreCase("<@!" + ScrapeBot.ScrapeBot.getSelfUser().getId() + ">")
                && args.get(1).equalsIgnoreCase("getresources")) {
            args.subList(0, 2).clear();
            new GetResources(event.getAuthor(), event.getChannel(), args);
        }
    }

    private ArrayList<String> getArguments(Message message) {
        return new ArrayList<>(Arrays.asList(message.getContentRaw().split("\\s+")));
    }
}
