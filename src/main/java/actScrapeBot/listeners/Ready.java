package actScrapeBot.listeners;

import actScrapeBot.ScrapeBot;
import actScrapeBot.commands.getCourses.CoursesReceiver;
import actScrapeBot.commands.getResources.ResourcesReceiver;
import actScrapeBot.commands.login.LoginReceiver;
import actScrapeBot.commands.logout.LogoutReceiver;
import actScrapeBot.managers.RequestManager;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Ready extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        // Triggers command initiation.
        ScrapeBot.ScrapeBot.addEventListener(new CommandTrigger());
        // Triggers request processing
        RequestManager.getInstance().addListener(
                new LoginReceiver(),
                new LogoutReceiver(),
                new ResourcesReceiver(),
                new CoursesReceiver()
        );

        ScrapeBot.ScrapeBot.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("activity.act.edu"));
    }
}
