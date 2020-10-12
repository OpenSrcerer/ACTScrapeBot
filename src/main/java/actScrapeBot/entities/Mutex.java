package actScrapeBot.entities;

import java.util.concurrent.Semaphore;

public interface Mutex {
    void acquireMutex() throws InterruptedException;

    void releaseMutex();
}
