package actScrapeBot.commands.getCourses;

import actScrapeBot.commands.ListenerType;
import actScrapeBot.listeners.RequestListener;
import actScrapeBot.requests.Request;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * Listener that processes and sends a message in
 * the respective Discord channel whenever a request
 * of its' expected type is complete.
 */
public class CoursesReceiver implements RequestListener {

    @Override
    public void requestComplete(Object result, MessageChannel channel) {
        // process courses
    }

    @Override
    public void requestFailed(Request request, MessageChannel channel) {

    }

    @Override
    public ListenerType getType() {
        return ListenerType.COURSES;
    }
}
