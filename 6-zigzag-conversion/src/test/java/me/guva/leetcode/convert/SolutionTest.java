package me.guva.leetcode.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.function.Function;

class SolutionTest {
    /**
     * The upper bound for valid input string length.
     */
    private static final int MAX_LENGTH = 1000;

    /**
     * The upper bound for acceptable number of rows.
     */
    private static final int MAX_NUM_ROWS = 1000;

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

    /**
     * We'll use this function to generate strings that repeate the alphabet.
     */
    private static final Function<Integer, Character> ALPHABET_CYCLER = i -> {
        return (char) ((i % ALPHABET_SIZE) + ASCII_ALPHABET_START);
    };

    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

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
        final String s = "PAYPALISHIRING";
        final int numRows = 3;
        final String expectedOutput = "PAHNAPLSIIGYIR";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final String s = "PAYPALISHIRING";
        final int numRows = 4;
        final String expectedOutput = "PINALSIGYAHRPI";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final String s = "A";
        final int numRows = 1;
        final String expectedOutput = "A";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxLengthSingleRowTest() {
        final String s = generateString(MAX_LENGTH, ALPHABET_CYCLER);
        final int numRows = 1;
        final String expectedOutput = s;
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void maxLengthAndRowsTest() {
        final String s = generateString(MAX_LENGTH, ALPHABET_CYCLER);
        final String expectedOutput = s;
        final String output = solution.convert(s, MAX_NUM_ROWS);
        assertEquals(expectedOutput, output);
    }

    @Test
    void rowsGreaterThanLengthTest() {
        final int length = MAX_LENGTH / 2;
        final String s = generateString(length, ALPHABET_CYCLER);
        final String expectedOutput = s;
        final String output = solution.convert(s, MAX_NUM_ROWS);
        assertEquals(expectedOutput, output);
    }

    @Test
    void stringEndsOnUpperRowTest() {
        final String s = "abcde";
        final int numRows = 3;
        final String expectedOutput = "aebdc";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void stringEndsOnLowerRowTest() {
        final String s = "abcdefg";
        final int numRows = 3;
        final String expectedOutput = "aebdfcg";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void stringEndsOnInnerRowDownwardTest() {
        final String s = "abcdef";
        final int numRows = 3;
        final String expectedOutput = "aebdfc";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }

    @Test
    void stringEndsOnInnerRowUpwardTest() {
        final String s = "abcdefgh";
        final int numRows = 3;
        final String expectedOutput = "aebdfhcg";
        final String output = solution.convert(s, numRows);
        assertEquals(expectedOutput, output);
    }
}
