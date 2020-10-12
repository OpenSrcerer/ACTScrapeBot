package actScrapeBot.entities;

import java.util.concurrent.Semaphore;

public class WebClient implements Mutex {

    private static final Semaphore mutex = new Semaphore(1);
    private static com.gargoylesoftware.htmlunit.WebClient client;



    @Override
    public void acquireMutex() throws InterruptedException {
        mutex.acquire();
    }

    @Override
    public void releaseMutex() {
        mutex.release();
    }
}
