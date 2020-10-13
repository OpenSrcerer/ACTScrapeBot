package actScrapeBot.preparedStatements;

import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;

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
