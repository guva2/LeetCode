package me.guva.leetcode.is_palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

    @Test
    void firstExampleTest() {
        final int input = 121;
        final boolean expectedOutput = true;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final int input = -121;
        final boolean expectedOutput = false;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final int input = 10;
        final boolean expectedOutput = false;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void evenLengthPalindromeTest() {
        final int input = 1221;
        final boolean expectedOutput = true;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void zeroTest() {
        final int input = 0;
        final boolean expectedOutput = true;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void minValueTest() {
        final int input = Integer.MIN_VALUE;
        final boolean expectedOutput = false;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxValueTest() {
        final int input = Integer.MIN_VALUE;
        final boolean expectedOutput = false;
        final boolean output = solution.isPalindrome(input);
        assertEquals(expectedOutput, output);
    }
}
