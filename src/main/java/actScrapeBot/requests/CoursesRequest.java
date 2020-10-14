package actScrapeBot.requests;

import actScrapeBot.callables.CoursesCallable;
import actScrapeBot.callables.RequestCallable;
import actScrapeBot.entities.Course;
import actScrapeBot.managers.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Request that contains necessary details for
 * Courses to be retrieved.
 */
public class CoursesRequest implements Request {
    private final CoursesCallable callable;
    private static final Logger lgr = LoggerFactory.getLogger(CoursesRequest.class);

    private List<Course> courseList = null;

    public CoursesRequest(CoursesCallable cllbl) {
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
        courseList = callable.call();
    }

    @Override
    public List<Course> getValue() {
        return courseList;
    }

    @Override
    public RequestCallable getCallable() {
        return callable;
    }
}
