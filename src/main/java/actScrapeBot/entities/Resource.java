package actScrapeBot.entities;

public class Resource extends Course {

    private final String resourceName, resourceLink, resourceType;

    public Resource(String rName, String rLink, String rType, Course course) throws IllegalArgumentException {
        super(course);

        if (rName == null) {
            throw new IllegalArgumentException("Provided Resource Name was null!");
        } else if (rLink == null) {
            throw new IllegalArgumentException("Provided Resource Link was null!");
        } else if (rType == null) {
            throw new IllegalArgumentException("Provided Resource Type was null!");
        }

        resourceName = rName;
        resourceLink = rLink;
        resourceType = rType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public String getResourceType() {
        return resourceType;
    }
}