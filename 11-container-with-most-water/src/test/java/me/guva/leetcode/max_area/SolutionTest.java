package me.guva.leetcode.max_area;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

    @Test
    void firstExampleTest() {
        final int[] input = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        final int expectedOutput = 49;
        final int output = solution.maxArea(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final int[] input = new int[] {1, 1};
        final int expectedOutput = 1;
        final int output = solution.maxArea(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void minimumAreaTest() {
        final int[] input = new int[] {0, 0};
        final int expectedOutput = 0;
        final int output = solution.maxArea(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maximumAreaTest() {
        final int maximumLines = 10000;
        final int maximumHeight = 1000;
        final int[] input = new int[maximumLines];
        Arrays.setAll(input, i -> maximumHeight);
        final int expectedOutput = 9999000;
        final int output = solution.maxArea(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void mountainTest() {
        final int[] input = new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1};
        final int expectedOutput = 12;
        final int output = solution.maxArea(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void valleyTest() {
        final int[] input = new int[] {5, 4, 3, 2, 1, 2, 3, 4, 5};
        final int expectedOutput = 40;
        final int output = solution.maxArea(input);
        assertEquals(expectedOutput, output);
    }
}
