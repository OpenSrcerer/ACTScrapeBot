package actScrapeBot.entities;

/**
 * Manages instances of an ACT User.
 */
public class ActUser {
    private final String discordUserId, actUsername, actPassword;

    public ActUser() {
        discordUserId = "";
        actUsername = "";
        actPassword = "";
    }

    public ActUser(String dId, String actUser, String actPass) throws IllegalArgumentException {

        if (dId == null) {
            throw new IllegalArgumentException("Provided Discord ID was null!");
        } else if (actUser == null) {
            throw new IllegalArgumentException("Provided Act Username was null!");
        } else if (actPass == null) {
            throw new IllegalArgumentException("Provided Act Password was null!");
        }

        discordUserId = dId;
        actUsername = actUser;
        actPassword = actPass;
    }

    public String getDiscordUserId() {
        return discordUserId;
    }

    public String getActUsername() {
        return actUsername;
    }

    public boolean isAnonymous() {
        return actUsername.isEmpty() || discordUserId.isEmpty();
    }
}
