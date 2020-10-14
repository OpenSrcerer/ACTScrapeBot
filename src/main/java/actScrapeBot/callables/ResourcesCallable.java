package actScrapeBot.callables;

import actScrapeBot.entities.ActUser;
import actScrapeBot.entities.Resource;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * WebClient Code to run when GetResources is called.
 */
public class ResourcesCallable implements RequestCallable, Callable<List<Resource>> {

    private final MessageChannel requestChannel;
    private final ActUser requestUser;
    private final String requestCourse, resourceKey;

    public ResourcesCallable(MessageChannel rChannel, ActUser rUser, String rCourse, String rKey) {
        requestChannel = rChannel;
        requestUser = rUser;
        requestCourse = rCourse;
        resourceKey = rKey;
    }

    @Override
    public List<Resource> call() {
        // code to get resource
        return null;
    }

    @Override
    public MessageChannel getChannel() {
        return requestChannel;
    }
}
