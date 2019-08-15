package ru.otus.l141;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

//TODO please FIXME with monitor
// Вопросы:
// - Что делает это многопоточное приложение?
// - Какие есть проблемы в данном многопоточном приложении?
// - Запустим приложение прямо сейчас!
// - Из какого потока летит исключение?
// - Из какого метода летит исключение?
// - Какие есть варианты решения этой проблемы?
// - Какой объект может быть монитором?
// - Сделаем фикс прямо сейчас!
// - Какие есть проблемы в решении с монитором?
// - Какие проблемы остаются в коде?
// - *Для чего тут нужен CountDownLatch?
// - *Зачем вызывать join() на потоках?
public class FixMe1WithMonitorUnitTest {
    @Test
    public void testMonitorWorksGreat() throws InterruptedException {

        final List<String> list = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(1);
        List<Throwable> throwables = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            try {
                latch.await();
                for (int i = 0; i < 1000; i++) {
                    out.println("starting adding email " + i);
                    synchronized (list) {
                        list.add(randomAlphabetic(10) + "@gmail.com");
                    }
                    out.println("finishing adding email " + i);
                }
            } catch (Throwable throwable) {
                throwables.add(throwable);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                latch.await();
                for (int i = 0; i < 1000; i++) {
                    out.println("starting read iteration " + i);
                    synchronized (list) {
                        list.forEach(out::println);
                    }
                    out.println("finishing read iteration " + i);
                }
            } catch (Throwable throwable) {
                throwables.add(throwable);
            }
        });

        t1.start();
        t2.start();

        latch.countDown();

        t1.join();
        t2.join();

        if (!throwables.isEmpty()) {
            Assert.fail(throwables.toString());
        }
    }
}
