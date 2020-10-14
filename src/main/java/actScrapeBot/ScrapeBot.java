package actScrapeBot;

import actScrapeBot.callables.InitToken;
import actScrapeBot.managers.WebClient;
import actScrapeBot.listeners.Ready;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class ScrapeBot {
    public static JDA ScrapeBot;
    private static final Logger logger = LoggerFactory.getLogger(ScrapeBot.class);

    private static final EnumSet<GatewayIntent> intents = EnumSet.of(
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
            GatewayIntent.DIRECT_MESSAGES
    );

    /**
     * Creates the bot instance with defined intents and policies.
     * Other listeners are defined in:
     * @see Ready
     */
    public static void execute() {
        String token = new InitToken().call();

        if (token == null) {
            logger.warn("Token was not initiaized. Canceling start-up operation.");
        }

        new WebClient();

        try {
            ScrapeBot = JDABuilder
                    .create(token, intents)
                    .disableCache(
                            CacheFlag.ACTIVITY,
                            CacheFlag.EMOTE,
                            CacheFlag.CLIENT_STATUS,
                            CacheFlag.MEMBER_OVERRIDES,
                            CacheFlag.VOICE_STATE
                    )
                    .setMemberCachePolicy(MemberCachePolicy.NONE)
                    .setChunkingFilter(ChunkingFilter.NONE)
                    .setEnableShutdownHook(true)
                    .addEventListeners(new Ready())
                    .build();
        } catch (LoginException ex) {
            logger.error("Error while logging into the Discord Gateway!", ex);
            return;
        }

        ScrapeBot.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("classes load >_<"));
    }
}
