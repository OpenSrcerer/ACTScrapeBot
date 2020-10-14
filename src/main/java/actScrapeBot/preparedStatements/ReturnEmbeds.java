package actScrapeBot.preparedStatements;

import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;

/**
 * Contains all the possible return value templates
 * to be shown to the Discord user.
 */
public class ReturnEmbeds {

    public static EmbedBuilder returnLoginSuccessful(String actUser) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Successfully logged in with the account:");
        eb.setDescription(actUser);
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }

    public static EmbedBuilder returnLogoutSuccessful(String actUser) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Successfully logged out from the account:");
        eb.setDescription(actUser);
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }
}
