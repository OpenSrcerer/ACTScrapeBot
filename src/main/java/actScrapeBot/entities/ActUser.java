package actScrapeBot.entities;

public class ActUser {
    private final String discordUserId, actUsername;

    public ActUser(String dId) {
        discordUserId = dId;
        actUsername = null;
    }

    public ActUser(String dId, String actUser) {
        actUsername = actUser;
        discordUserId = dId;
    }

    public String getDiscordUserId() {
        return discordUserId;
    }

    public String getActUsername() {
        return actUsername;
    }
}
