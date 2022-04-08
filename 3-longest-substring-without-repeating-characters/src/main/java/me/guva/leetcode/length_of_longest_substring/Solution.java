package me.guva.leetcode.length_of_longest_substring;

final class Solution {
    /**
     * All characters must be one of the 256 ASCII Characters.
     */
    private static final int ASCII_RANGE = 256;

    private Solution() { }

    public static int lengthOfLongestSubstring(final String s) {
        final boolean[] charBitMap = new boolean[ASCII_RANGE];
        int head = 0;
        int tail = advanceTail(0, s, charBitMap);
        int longestLength = tail - head;
        while (tail < s.length()) {
            head = advanceHead(head, tail, s, charBitMap);
            tail = advanceTail(tail + 1, s, charBitMap);
            longestLength = getNewLongestLength(head, tail, longestLength);
        }
        return longestLength;
    }

    private static int advanceHead(final int startingHead,
                                   final int tail,
                                   final String s,
                                   final boolean[] charBitMap) {
        final char duplicate = s.charAt(tail);
        int head = startingHead;
        char headChar = s.charAt(head++);
        while (headChar != duplicate) {
            clearBit(charBitMap, headChar);
            headChar = s.charAt(head++);
        }

        return head;
    }

    private static int advanceTail(final int startingTail,
                                   final String s,
                                   final boolean[] charBitMap) {
        final int length = s.length();
        for (int tail = startingTail; tail < length; tail++) {
            final char tailChar = s.charAt(tail);
            if (!setBit(charBitMap, tailChar)) {
                return tail;
            }
        }
        return length;
    }

    private static int getNewLongestLength(final int head,
                                           final int tail,
                                           final int currentLongestLength) {
        final int length = tail - head;
        return Math.max(currentLongestLength, length);
    }

    private static boolean setBit(final boolean[] charBitMap, final char c) {
        final int charIndex = (int) c;
        final boolean isUnique = !charBitMap[charIndex];
        if (isUnique) {
            charBitMap[charIndex] = true;
        }
        return isUnique;
    }

    private static void clearBit(final boolean[] charBitMap, final char c) {
        final int charIndex = (int) c;
        charBitMap[charIndex] = false;
    }
}
