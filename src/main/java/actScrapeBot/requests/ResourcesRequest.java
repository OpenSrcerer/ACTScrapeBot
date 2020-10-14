package actScrapeBot.requests;

import actScrapeBot.callables.RequestCallable;
import actScrapeBot.callables.ResourcesCallable;
import actScrapeBot.entities.Resource;
import actScrapeBot.managers.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Request that contains necessary details for
 * resources to be retrieved.
 */
public class ResourcesRequest implements Request {

    private static final Logger lgr = LoggerFactory.getLogger(ResourcesRequest.class);
    private final ResourcesCallable callable;

    // Return Item
    private List<Resource> resourceList = new ArrayList<>();

    public ResourcesRequest(ResourcesCallable cllbl) {
        callable = cllbl;
        queue();
    }

    @Override
    public void queue() {
        try {
            RequestManager.getInstance().queueRequest(this);
        } catch (InterruptedException ex) {
            lgr.warn("Thread interrupted while queuing request!");
        }
    }

    @Override
    public void run() {
        resourceList = callable.call();
    }

    @Override
    public List<Resource> getValue() {
        return resourceList;
    }

    @Override
    public RequestCallable getCallable() {
        return callable;
    }
}
