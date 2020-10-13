package actScrapeBot.callables;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

import actScrapeBot.ScrapeBot;

/**
 * Initializes token variables for loading.
 */
public class InitToken implements Callable<String> {

    private static final Logger logger = LoggerFactory.getLogger(InitToken.class);

    public InitToken() {
        this.call();
    }

    @Override
    public String call() {
        String token = null;

        try {
            // Initialize configuration file found in resources.
            // Hidden from everyone, it contains the bot token which should be kept safe.
            InputStream configFile = ScrapeBot.class.getClassLoader().getResourceAsStream("config.json");

            if (configFile == null) {
                logger.error("JSON config file not found.");
                return null;
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(
                    new InputStreamReader(configFile, StandardCharsets.UTF_8
                    )
            );

            token = jsonObject.get("Token").toString();

        } catch (FileNotFoundException ex) {
            logger.error("JSON config file not found.");
        } catch (ParseException ex) {
            logger.error("Parsing error!", ex);
        } catch (IOException ex) {
            logger.error("I/O Error while parsing JSON file.", ex);
        }

        return token;
    }
}
