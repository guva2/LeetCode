package me.guva.leetcode.reverse;

class Solution {
    /**
     * This problem is framed in decimal, so we'll use 10 to extract digits.
     */
    private static final int BASE = 10;

    public static int reverse(final int x) {
        int reversed = 0;
        int prevDigit = getDigit(x);
        int remainingInput = removeDigit(x);
        while (remainingInput != 0) {
            reversed = addDigit(reversed, prevDigit);
            prevDigit = getDigit(remainingInput);
            remainingInput = removeDigit(remainingInput);
        }

        if (magnitudeWillOverflow(reversed, remainingInput)) {
            return 0;
        }

        return addDigit(reversed, prevDigit);
    }

    private static int getDigit(final int remainingInput) {
        return remainingInput % BASE;
    }

    private static int addDigit(final int reversed, final int nextDigit) {
        final int translatedReversedDigits = reversed * BASE;
        return translatedReversedDigits + nextDigit;
    }

    private static int removeDigit(final int input) {
        return input / BASE;
    }

    private static boolean magnitudeWillOverflow(final int reversed,
                                                 final int remainingInput) {
        if (reversed > 0) {
            return willOverflow(reversed, remainingInput);
        } else {
            return willUnderflow(reversed, remainingInput);
        }
    }

    private static boolean willOverflow(final int reversed,
                                        final int remainingInput) {
        // No need to check the last digit because there is no valid integer
        // whose reverse would overflow by < 10.
        final int tenthMaxValue = Integer.MAX_VALUE / BASE;
        return reversed > tenthMaxValue;
    }

    private static boolean willUnderflow(final int reversed,
                                         final int remainingInput) {
        // No need to check the last digit because there is no valid integer
        // whose reverse would underflow by < 10.
        final int tenthMinValue = Integer.MIN_VALUE / BASE;
        return reversed < tenthMinValue;
    }
}
