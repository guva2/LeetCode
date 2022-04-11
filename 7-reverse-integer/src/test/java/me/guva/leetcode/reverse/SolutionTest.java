package me.guva.leetcode.reverse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

    @Test
    void firstExampleTest() {
        final int input = 123;
        final int expectedOutput = 321;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final int input = -123;
        final int expectedOutput = -321;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final int input = 120;
        final int expectedOutput = 21;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void zeroTest() {
        final int input = 0;
        final int expectedOutput = 0;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void overflowTest() {
        final int input = Integer.MAX_VALUE;
        final int expectedOutput = 0;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void underflowTest() {
        final int input = Integer.MIN_VALUE;
        final int expectedOutput = 0;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxExpectedOutputTest() {
        final int input = 2143847412;
        final int expectedOutput = 2147483412;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void minExpectedOutputTest() {
        final int input = -2143847412;
        final int expectedOutput = -2147483412;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void trailingZerosTest() {
        final int input = 100000;
        final int expectedOutput = 1;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void negativeTrailingZerosTest() {
        final int input = -100000;
        final int expectedOutput = -1;
        final int output = solution.reverse(input);
        assertEquals(expectedOutput, output);
    }
}
