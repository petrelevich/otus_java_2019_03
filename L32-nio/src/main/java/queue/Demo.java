package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) throws InterruptedException {
        new Demo().go();
    }

    private void go() throws InterruptedException {
        MessageSystem ms = new MessageSystem();
        DatabaseService ds = new DatabaseService(ms);
        ds.init();
        Frontend fs = new Frontend(ms);
        fs.init();

        ms.init();

        logger.info("creating user 1");
        fs.createUser("testUSer_1");

        logger.info("creating user 2");
        fs.createUser("testUSer_2");

        logger.info("creating user 3");
        fs.createUser("testUSer_3");

        logger.info("done");
    }
}
