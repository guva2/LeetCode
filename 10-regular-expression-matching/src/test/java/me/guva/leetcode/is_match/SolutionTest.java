package me.guva.leetcode.is_match;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

    @Test
    void firstExampleTest() {
        final String s = "aa";
        final String p = "a";
        final boolean expectedOutput = false;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final String s = "aa";
        final String p = "a*";
        final boolean expectedOutput = true;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final String s = "ab";
        final String p = ".*";
        final boolean expectedOutput = true;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void simpleExactPatternMatchTest() {
        final String s = "abcdefg";
        final String p = "abcdefg";
        final boolean expectedOutput = true;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void excessPatternMismatchTest() {
        final String s = "abcd";
        final String p = "abcdefg";
        final boolean expectedOutput = false;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void excessStringMismatchTest() {
        final String s = "abcdefg";
        final String p = "abcd";
        final boolean expectedOutput = false;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void charDiffMismatchTest() {
        final String s = "abcdefg";
        final String p = "abdcefg";
        final boolean expectedOutput = false;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void redundantMatchPerformanceTest() {
        final String s = "gggggggggggggggggggg";
        final String p = "g*g*g*g*g*g*g*g*g*g*";
        final boolean expectedOutput = true;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }

    @Test
    void multipleZeroOrMoreMatchTest() {
        final String s = "abbbbcddeeeefggg";
        final String p = "ab*c*dde*fg*";
        final boolean expectedOutput = true;
        final boolean output = solution.isMatch(s, p);
        assertEquals(expectedOutput, output);
    }
}
