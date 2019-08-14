package ru.itvitality.otus.java;

import ru.itvitality.otus.java.runner.ProcessRunnerImpl;
import ru.itvitality.otus.java.server.EchoSocketMessageServer;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class ServerMain
{
    private static final String CLIENT_START_COMMAND = "java -jar ../_1611-client/target/client-jar-with-dependencies.jar -port 5051";
    private static final int CLIENT_START_DELAY_SEC = 5;

    public static void main( String[] args ) throws Exception {
        new ServerMain().start();
    }

    private void start() throws Exception {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        startClient( executorService );

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("ru.itvitality.otus.java:type=Server");

        EchoSocketMessageServer server = new EchoSocketMessageServer();
        mBeanServer.registerMBean(server, objectName);

        server.start();

        executorService.shutdown();

    }

    private void startClient(ScheduledExecutorService executorService) {
        executorService.schedule(() -> {
            try {
                new ProcessRunnerImpl().start(CLIENT_START_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }, CLIENT_START_DELAY_SEC, TimeUnit.SECONDS);

    }
}
