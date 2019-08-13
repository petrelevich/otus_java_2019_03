package queue.mesages;

public interface MessageClient {
    void accept(Message msg) throws InterruptedException;

    void init();
}
