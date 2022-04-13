package me.guva.leetcode.is_palindrome;

class Solution {
    /**
     * This problem is framed in decimal so we define our base as 10.
     */
    private static final int BASE = 10;

    public static boolean isPalindrome(final int x) {
        if (x < 0) {
            return false;
        }

        final long reversedNumber = reverseNumber(x);
        return reversedNumber == x;
    }

    private static long reverseNumber(final int number) {
        int remainingNumber = number;
        long reversedNumber = 0;
        while (remainingNumber  > 0) {
            final int nextDigit = remainingNumber % BASE;
            final long translatedReversedNumber = reversedNumber * BASE;
            reversedNumber = translatedReversedNumber + nextDigit;
            remainingNumber /= BASE;
        }
        return reversedNumber;
    }
}
