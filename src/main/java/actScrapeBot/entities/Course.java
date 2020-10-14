package actScrapeBot.entities;

import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * Manages and holds information for a course.
 */
public class Course {

    private final String courseName, courseLecturer, courseTerm;
    // The variable below holds the information
    // within the course. Anything
    // posted by the lecturer goes here.
    private final Map<String, List<Resource>> resources;

    public Course(String cName, String cLecturer, String cTerm, Map<String, List<Resource>> res) throws IllegalArgumentException {
        if (cName == null) {
            throw new IllegalArgumentException("Provided Course Name was null!");
        } else if (cLecturer == null) {
            throw new IllegalArgumentException("Provided Course Lecturer was null!");
        } else if (cTerm == null) {
            throw new IllegalArgumentException("Provided Course Term was null!");
        } else if (res == null) {
            throw new IllegalArgumentException("Provided Course Resources were null!");
        }

        courseName = cName;
        courseLecturer = cLecturer;
        courseTerm = cTerm;
        resources = res;
    }

    public Course(Course course)  {
        courseName = course.getCourseName();
        courseLecturer = course.getCourseLecturer();
        courseTerm = course.getCourseTerm();
        resources = course.getResources();
    }

    @Nullable
    public List<Resource> getResources(String key) {
        return resources.get(key);
    }

    @Nonnull
    public Map<String, List<Resource>> getResources() {
        return resources;
    }

    @Nonnull
    public String getCourseLecturer() {
        return courseLecturer;
    }

    @Nonnull
    public String getCourseName() {
        return courseName;
    }

    @Nonnull
    public String getCourseTerm() {
        return courseTerm;
    }
}
