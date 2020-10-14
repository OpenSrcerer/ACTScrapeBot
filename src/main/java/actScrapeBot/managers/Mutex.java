package actScrapeBot.managers;

public interface Mutex {
    void acquireMutex() throws InterruptedException;

    void releaseMutex();
}
