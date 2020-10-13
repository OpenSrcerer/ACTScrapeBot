package actScrapeBot.entities;

public interface Mutex {
    void acquireMutex() throws InterruptedException;

    void releaseMutex();
}
