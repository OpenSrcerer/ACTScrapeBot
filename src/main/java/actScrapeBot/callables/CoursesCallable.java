package actScrapeBot.callables;

import actScrapeBot.entities.ActUser;
import actScrapeBot.entities.Course;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * WebClient Code to run when GetCourses is called.
 */
public class CoursesCallable implements RequestCallable, Callable<List<Course>> {

    private final MessageChannel requestChannel;
    private final ActUser requestUser;
    private final String courseName;

    public CoursesCallable(MessageChannel rChannel, ActUser rUser, String rCourse) {
        requestChannel = rChannel;
        requestUser = rUser;
        courseName = rCourse;
    }

    @Override
    public List<Course> call() {
        // get course, and its' resources
        //return course;
        return null;
    }

    @Override
    public MessageChannel getChannel() {
        return requestChannel;
    }
}
