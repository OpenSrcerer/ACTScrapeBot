package actScrapeBot.managers;

import actScrapeBot.entities.ActUser;

import java.util.ArrayList;

public class UserManager {

    protected static final UserManager instance = new UserManager();
    private static final ArrayList<ActUser> loggedInUsers = new ArrayList<>();

    public static UserManager getInstance() {
        return instance;
    }

    public void addLoggedInUser(ActUser actUser) {
        loggedInUsers.add(actUser);
    }

    public void removeLoggedInUser(ActUser actUser) { loggedInUsers.remove(actUser); }

    /**
     * Checks loggedInUsers to see if user has previously logged in.
     * If not, returns anonymous user with no ActUsername.
     * @param discordId User ID of Discord user.
     * @return Anonymous or Valid ActUser
     */
    public ActUser getLoggedInUser(String discordId) {
        for (ActUser user : loggedInUsers) {
            if (user.getDiscordUserId().equals(discordId)) {
                return user;
            }
        }
        return new ActUser();
    }
}
