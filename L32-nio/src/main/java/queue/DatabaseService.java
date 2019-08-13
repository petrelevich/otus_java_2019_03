package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import queue.mesages.Message;
import queue.mesages.MessageClient;


public class DatabaseService implements MessageClient {
    private static Logger logger = LoggerFactory.getLogger(DatabaseService.class);
    private final MessageSystem ms;

    DatabaseService(MessageSystem ms) {
        this.ms = ms;
    }

    @Override
    public void init() {
        //почему не в конструкторе?
        this.ms.setDatabaseService(this);
    }

    @Override
    public void accept(Message msg) throws InterruptedException {
        String dataFromUI = msg.process();

        logger.info("message from UI: {}", dataFromUI);
        String messageForUI = dataFromUI.toUpperCase() + "+DB";

        Thread.sleep(10_000);

        Message msgForFE = ms.createMessageForFrontend(messageForUI);
        ms.sendMessage(msgForFE);
    }
}
