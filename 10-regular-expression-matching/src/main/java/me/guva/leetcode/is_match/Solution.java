package me.guva.leetcode.is_match;

class Solution {

    /**
     * The wildcard character as defined by the problem statement.
     */
    private static final char WILDCARD = '.';

    /**
     * The zero or more indicator as defined by the problem statement.
     */
    private static final char ZERO_OR_MORE = '*';

    public static boolean isMatch(final String s, final String p) {
        return isMatch(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }

    private static boolean isMatch(final String str,
                                   final String pattern,
                                   final int strIndex,
                                   final int patternIndex,
                                   final Boolean[][] cache) {

        if (cache[strIndex][patternIndex] == null) {
            cache[strIndex][patternIndex] = isPatternMatch(str,
                                                           pattern,
                                                           strIndex,
                                                           patternIndex,
                                                           cache);
        }

        return cache[strIndex][patternIndex];
    }

    private static boolean isPatternMatch(final String str,
                                          final String pattern,
                                          final int strIndex,
                                          final int patternIndex,
                                          final Boolean[][] cache) {

        if (strIndex == str.length() && patternIndex == pattern.length()) {
            return true;
        }

        boolean output = false;
        if (isZeroOrMore(pattern, patternIndex)) {
            output |= isMatch(str, pattern, strIndex, patternIndex + 2, cache);
            output |= isCharMatch(str, pattern, strIndex, patternIndex)
                && isMatch(str, pattern, strIndex + 1, patternIndex, cache);
        } else {
            output |= isCharMatch(str, pattern, strIndex, patternIndex)
                && isMatch(str, pattern, strIndex + 1, patternIndex + 1, cache);
        }

        return output;
    }

    private static boolean isZeroOrMore(final String pattern,
                                        final int patternIndex) {
        return patternIndex + 1 < pattern.length()
            && pattern.charAt(patternIndex + 1) == ZERO_OR_MORE;
    }

    private static boolean isCharMatch(final String str,
                                       final String pattern,
                                       final int strIndex,
                                       final int patternIndex) {
        if (strIndex >= str.length() || patternIndex >= pattern.length()) {
            return false;
        }

        final char strChar = str.charAt(strIndex);
        final char patternChar = pattern.charAt(patternIndex);
        return patternChar == '.' || patternChar == strChar;
    }

}
