package actScrapeBot.managers;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * Manages a WebClient instance, making sure
 * that all operations are atomic.
 */
public class WebClient implements Mutex {

    private final Semaphore mutex = new Semaphore(1);
    private final com.gargoylesoftware.htmlunit.WebClient client;

    public WebClient() {
        client = new com.gargoylesoftware.htmlunit.WebClient();
    }

    public HtmlPage getPage(String pageName) throws IOException {
        return client.getPage(pageName);
    }

    @Override
    public void acquireMutex() throws InterruptedException {
        mutex.acquire();
    }

    @Override
    public void releaseMutex() {
        mutex.release();
    }
}
