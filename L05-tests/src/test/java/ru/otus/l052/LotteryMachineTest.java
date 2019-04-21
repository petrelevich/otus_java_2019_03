package ru.otus.l052;

import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by tully.
 */
public class LotteryMachineTest {

    LotteryMachine lotteryMachine;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before all LotteryMachineTest tests");
    }

    //before() is overridden in sub class
    @BeforeEach
    public void beforeLotteryMachineTest() {
    //public void before() {
        System.out.println("Before LotteryMachineTest");
        lotteryMachine = new LotteryMachine(5);
    }

    @AfterEach
    public void afterLotteryMachineTest() {
        System.out.println("After LotteryMachineTest");
        lotteryMachine.dispose();
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After all LotteryMachineTest tests");
    }


    @Test
    public void oneEmail() throws InterruptedException {
        List<String> result = lotteryMachine.draw(Collections.singletonList("test@mail.ru"));
        assertEquals(1, result.size());
        assertEquals("test@mail.ru", result.get(0));
    }

    @Test
    public void NPETest() {
        assertThrows(NullPointerException.class, () -> {
            List<String> result = lotteryMachine.setSeed(100500)
                    .draw(null);
        });
    }

}
