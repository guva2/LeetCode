package me.guva.leetcode.my_atoi;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

class Solution {
    /**
     * The problem defines the space character as the only whitespace character.
     */
    private static final char WHITESPACE_CHAR = ' ';

    /**
     * This character designates that the number will be negative.
     */
    private static final char NEGATIVE_SIGN_CHAR = '-';

    /**
     * This character designates that the number will be positive.
     */
    private static final char POSITIVE_SIGN_CHAR = '+';

    /**
     * This problem is framed in decimal so we define our base as 10.
     */
    private static final int BASE = 10;

    /**
     * A sign contains a multiplicand by which the value of read digits will
     * be multiplied, and a minValue which defines the underflow boundary.
     *
     * Note that we actually read the negative value of the input number in
     * order to avoid overflow issues with -Integer.MIN_VALUE.
     */
    private enum SIGN {
        /**
         * Negative numbers have multiplicand 1 because they don't require a
         * sign change once read as a negative value.
         *
         * Naturally, we use Integer.MIN_VALUE as the underflow boundary for
         * negative numbers.
         */
        NEGATIVE(1, Integer.MIN_VALUE),
        /**
         * Positive numbers have multiplicand -1 because they do require a sign
         * change once read as a negative value.
         *
         * Because |Integer.MIN_VALUE| > |Integer.MAX_VALUE|, we can't use
         * Integer.MIN_VALUE as an underflow boundary for positive integers
         * without encountering overflow issues when converting to positive. As
         * such, we use -Integer.MAX_VALUE as the underflow boundary for
         * positive integers.
         */
        POSITIVE(-1, -Integer.MAX_VALUE);

        /**
         * The multiplicand that ultimately decides the sign of the number.
         *
         * Note again that counterintuively:
         *     Positive numbers require a multiplicand of -1.
         *     Negative numbers require a multiplicand of +1.
         */
        private int multiplicand;

        /**
         * The boundary that will be used to check for integer underflow.
         *
         * Note again that these must differ for positive/negative numbers.
         */
        private int minValue;
        SIGN(final int multiplicand, final int minValue) {
            this.multiplicand = multiplicand;
            this.minValue = minValue;
        }

        private int getMultiplicand() {
            return this.multiplicand;
        }

        private int getMinValue() {
            return this.minValue;
        }
    }

    public static int myAtoi(final String s) {
        final CharacterIterator iterator = new StringCharacterIterator(s);
        ignoreWhitespace(iterator);
        final SIGN sign = readSign(iterator);
        final int value = readDigits(iterator, sign.getMinValue());
        return sign.getMultiplicand() * value;

    }

    private static void ignoreWhitespace(final CharacterIterator iterator) {
        while (iterator.current() == WHITESPACE_CHAR) {
            iterator.next();
        }
    }

    private static SIGN readSign(final CharacterIterator iterator) {
        SIGN sign = SIGN.POSITIVE;
        switch (iterator.current()) {
            case NEGATIVE_SIGN_CHAR:
                sign = SIGN.NEGATIVE;
            case POSITIVE_SIGN_CHAR:
                iterator.next();
            default:
                return sign;
        }
    }

    private static int readDigits(final CharacterIterator iterator,
                                  final int minValue) {
        int output = 0;
        char digitChar = iterator.current();
        while (Character.isDigit(digitChar)) {
            final int digit = Character.digit(digitChar, BASE);
            if (willUnderflow(output, digit, minValue)) {
                return minValue;
            }
            output = appendDigit(output, digit);
            digitChar = iterator.next();
        }
        return output;
    }

    private static int appendDigit(final int number, final int digit) {
        final int translatedNumber = number * 10;
        return translatedNumber - digit;
    }

    private static boolean willUnderflow(final int number,
                                         final int digit,
                                         final int minValue) {
        final int tenthMinValue = minValue / BASE;
        if (number > tenthMinValue) {
            return false;
        } else if (number < tenthMinValue) {
            return true;
        } else {
            final int minValueLastDigit = minValue % BASE;
            return -digit < minValueLastDigit;
        }
    }
}
