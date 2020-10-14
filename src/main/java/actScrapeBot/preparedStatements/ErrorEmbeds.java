package actScrapeBot.preparedStatements;

import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;

/**
 * Contains all possible error templates to be shown
 * to the Discord user.
 */
public class ErrorEmbeds {
    public static EmbedBuilder errorLogin() {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Failed to login using given credentials.");
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }
}
