package actScrapeBot;

/**
 * <h1>ACT Scrape Bot</h1>
 *
 * <p>ACT Scrape Bot is a tool used to retrieve
 * information from the act.edu & activity.act.edu
 * sites, and relay them to a Discord Server in the form
 * of a simple bot. However, the point of the project is
 * to create an interface that can be further expanded to
 * connect to different web services and fulfill various tasks.</p>
 *
 * <br>
 * <h3>Made for the ACT Spirit Day Hackathon 2020. <br> This work is licensed under the GNU General Public License v3.0</h3>
 *
 * @author Daniel Stefani (OpenSrcerer)
 * @version 0.0.1
 * @since 2020-10-12
 *
 *
 */
public class BotRunnable {
    public static void main (String[] args) {
        ScrapeBot.execute();
    }
}
