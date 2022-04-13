package me.guva.leetcode.my_atoi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

    @Test
    void firstExampleTest() {
        final String input = "42";
        final int expectedOutput = 42;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final String input = "   -42";
        final int expectedOutput = -42;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final String input = "4193 with words";
        final int expectedOutput = 4193;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void nearMinValueTest() {
        final String input = "-2147483647";
        final int expectedOutput = -2147483647;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void nearMaxValueTest() {
        final String input = "2147483646";
        final int expectedOutput = 2147483646;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void minValueTest() {
        final String input = "-2147483648";
        final int expectedOutput = -2147483648;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxValueTest() {
        final String input = "2147483647";
        final int expectedOutput = 2147483647;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void smallUnderflowTest() {
        final String input = "-2147483649";
        final int expectedOutput = -2147483648;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void smallOverflowTest() {
        final String input = "2147483648";
        final int expectedOutput = 2147483647;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void bigUnderflowTest() {
        final String input = "-9147483648";
        final int expectedOutput = -2147483648;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void bigOverflowTest() {
        final String input = "9147483648";
        final int expectedOutput = 2147483647;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void longPositiveIntegerTest() {
        final String input = "999999999999999999999999999999999999999999999999";
        final int expectedOutput = 2147483647;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void longNegativeIntegerTest() {
        final String input = "-99999999999999999999999999999999999999999999999";
        final int expectedOutput = -2147483648;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void emptyStringTest() {
        final String input = "";
        final int expectedOutput = 0;
        final int output = solution.myAtoi(input);
        assertEquals(expectedOutput, output);
    }
}
