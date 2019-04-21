package ru.otus.l052;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by tully.
 */
public class LotteryMachineSubTest extends LotteryMachineTest {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before all LotteryMachineSubTest tests");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before LotteryMachineSubTest");
    }

    @AfterEach
    public void afterLotteryMachineTest() {
        System.out.println("After LotteryMachineSubTest");
        lotteryMachine.dispose();
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After all LotteryMachineSubTest tests");
    }


    @Test
    public void tenEmailsSeed0() {
        List<String> result = lotteryMachine.setSeed(0)
                .draw(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        assertEquals(5, result.size());
        assertTrue(result.contains("0"));
        assertTrue(result.contains("5"));
        assertTrue(result.contains("7"));
        assertTrue(result.contains("8"));
        assertTrue(result.contains("9"));
    }

    @Test
    public void tenEmailsSeed100500() {
        List<String> result = lotteryMachine.setSeed(100500)
                .draw(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        assertEquals(5, result.size());
        assertTrue(result.contains("1"));
        assertTrue(result.contains("3"));
        assertTrue(result.contains("7"));
        assertTrue(result.contains("0"));
        assertTrue(result.contains("9"));
    }
    
    @Disabled("It will fail")
    @ParameterizedTest
    @ValueSource(ints = {0, 100500})
    public void tenEmailsSomething(int number) {
        List<String> result = lotteryMachine.setSeed(number)
                .draw(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        assertEquals(5, result.size());
        assertTrue(result.contains("1"));
        assertTrue(result.contains("3"));
        assertTrue(result.contains("7"));
        assertTrue(result.contains("0"));
        assertTrue(result.contains("9"));
    }
}
