package me.guva.leetcode.longest_palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.function.Function;

class SolutionTest {
    /**
     * The lower bound for valid input string length.
     */
    private static final int MIN_LENGTH = 1;

    /**
     * The upper bound for valid input string length.
     */
    private static final int MAX_LENGTH = 1000;

    /**
     * We define the size of the alphabet so we can generate repeating
     * strings without palindromic substrings.
     */
    private static final int ALPHABET_SIZE = 26;

    /**
     * We define the ASCII index of the start of the lower case alphabet
     * so we can generate repeating strings without palindromic substrings.
     */
    private static final int ASCII_ALPHABET_START = 97;

    private static String generateString(final int length,
            final Function<Integer, Character> letterGenerator) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(letterGenerator.apply(i));
        }
        return builder.toString();
    }

    @Test
    void firstExampleTest() {
        final String output = Solution.longestPalindrome("babad");
        final int expectedOutputLength = 3;
        assertEquals(expectedOutputLength, output.length());
    }

    @Test
    void secondExampleTest() {
        final String input = "cbbd";
        final String expectedOutput = "bb";
        final String output = Solution.longestPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void minLengthTest() {
        final String input = generateString(MIN_LENGTH, ignore -> 'g');
        final String expectedOutput = input;
        final String output = Solution.longestPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxLengthPalindromeTest() {
        final String input = generateString(MAX_LENGTH, ignore -> 'g');
        final String expectedOutput = input;
        final String output = Solution.longestPalindrome(input);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxLengthStringMinLengthPalindromeTest() {
        final Function<Integer, Character> alphabetCycler = i -> {
            return (char) ((i % ALPHABET_SIZE) + ASCII_ALPHABET_START);
        };
        final String input = generateString(MAX_LENGTH, alphabetCycler);
        final int expectedOutputLength = 1;
        final String output = Solution.longestPalindrome(input);
        assertEquals(expectedOutputLength, output.length());
    }
}
