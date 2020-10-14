package actScrapeBot.preparedStatements;

import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;

/**
 * Contains all possible Help templates to be
 * shown to the Discord user.
 */
public class HelpEmbeds {

    public static EmbedBuilder helpLogin() {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Command Usage:\n ```@ACTScrapeBot login <username> <password>```");
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }

    public static EmbedBuilder helpAlreadyLoggedIn(String actUser) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("You are already logged in with the account " + actUser + ". Would you like to log out instead:\n ```@ACTScrapeBot logout```");
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }

    public static EmbedBuilder helpPleaseLogin() {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("You must be logged in with an ACT account before performing this action.");
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }

    public static EmbedBuilder helpNotLoggedIn() {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("You are not logged in with any account. Would you like to log in instead:\n ```@ACTScrapeBot login <username> <password>```");
        eb.setTimestamp(Instant.now());
        eb.setColor(0xff0000);
        return eb;
    }
}
