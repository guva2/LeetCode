package me.guva.leetcode.longest_palindrome;

final class Solution {
    /**
     * We use a half step offset from the middle of the string when iterating
     * in order to account for both even and odd length palindromes. A
     * palindrome whose index is X.5 is odd length with X as its center. A
     * palindrome whose index is X.0 is even with X as its upper center.
     */
    private static final double OFFSET_INCREMENT = 0.5;

    private Solution() { }

    public static String longestPalindrome(final String s) {
        final double mid = s.length() / 2.0;
        String longestPalindrome = "";
        for (double offset = 0.0; offset < mid; offset += OFFSET_INCREMENT) {
            if (!lengthSurpassable(s, offset, longestPalindrome)) {
                return longestPalindrome;
            }

            final String palindrome = longestPalindromeAtOffset(s, mid, offset);
            longestPalindrome = longer(palindrome, longestPalindrome);
        }
        return longestPalindrome;
    }

    private static String longestPalindromeAtOffset(final String s,
                                                    final double mid,
                                                    final double offset) {
        final double firstIndex = mid - offset;
        final double lastIndex = mid + offset;
        final String firstPalindrome = longestPalindromeAtIndex(s, firstIndex);
        final String lastPalindrome = longestPalindromeAtIndex(s, lastIndex);
        return longer(firstPalindrome, lastPalindrome);
    }

    private static String longestPalindromeAtIndex(final String s,
                                                   final double index) {
        final int start = (int) Math.floor(index);
        final int end = (int) Math.ceil(index);
        return longestPalindromeFromRoot(s, start, end);
    }

    private static String longestPalindromeFromRoot(final String s,
                                                    final int start,
                                                    final int end) {
        final int previous = start - 1;
        final int next = end + 1;
        final boolean inBounds = previous >= 0 && end < s.length();
        if (inBounds && s.charAt(previous) == s.charAt(end)) {
            return longestPalindromeFromRoot(s, previous, next);
        } else {
            return s.substring(start, end);
        }
    }

    private static boolean lengthSurpassable(final String s,
                                             final double offset,
                                             final String palindrome) {
        final int maxLength = maxPalindromeLength(s.length(), offset);
        return maxLength > palindrome.length();
    }

    private static int maxPalindromeLength(final int length,
                                           final double offset) {
        final double mid = length / 2.0;
        final double firstRoot = mid - offset;
        final double maxLength = firstRoot * 2;
        return (int) maxLength;
    }

    private static String longer(final String firstString,
                                 final String lastString) {
        if (firstString.length() > lastString.length()) {
            return firstString;
        } else {
            return lastString;
        }
    }
}
