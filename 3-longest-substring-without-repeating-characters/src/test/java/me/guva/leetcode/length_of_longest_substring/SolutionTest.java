package me.guva.leetcode.length_of_longest_substring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void firstExampleTest() {
        final String input = "abcabcbb";
        final int output = Solution.lengthOfLongestSubstring(input);
        final int expectedOutput = 3;
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final String input = "bbbbb";
        final int output = Solution.lengthOfLongestSubstring(input);
        final int expectedOutput = 1;
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final String input = "pwwkew";
        final int output = Solution.lengthOfLongestSubstring(input);
        final int expectedOutput = 3;
        assertEquals(expectedOutput, output);
    }

    @Test
    void emptyStringTest() {
        final String input = "";
        final int output = Solution.lengthOfLongestSubstring(input);
        final int expectedOutput = 0;
        assertEquals(expectedOutput, output);
    }

    @Test
    void noRepeatedCharactersTest() {
        final String input = "arstneio";
        final int output = Solution.lengthOfLongestSubstring(input);
        final int expectedOutput = 8;
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxLengthTest() {
        final int maxLength = 50000;
        String input = "";
        final String repeatedString = "raisecount";
        while (input.length() < maxLength) {
            input += repeatedString;
        }

        final int output = Solution.lengthOfLongestSubstring(input);
        final int expectedOutput = 10;
        assertEquals(expectedOutput, output);
    }
}
