package me.guva.leetcode.convert;

class Solution {
    /**
     * Every zigzag should have 2 outer rows and n-2 inner rows.
     */
    private static final int NUM_OUTER_ROWS = 2;

    public static String convert(final String s, final int numRows) {
        if (numRows == 1) {
            return s;
        }

        final int cycle = calculateZigzagCycleLength(numRows);
        return constructZigzag(s, cycle);
    }

    private static int calculateZigzagCycleLength(final int numRows) {
        final int numInnerRows = numRows - NUM_OUTER_ROWS;
        final int numInnerElements = numInnerRows * 2;
        return numInnerElements + NUM_OUTER_ROWS;
    }

    private static String constructZigzag(final String s, final int cycle) {
        final StringBuilder builder = new StringBuilder(s.length());
        appendOuterRow(builder, s, cycle, 0);
        for (int i = 1, j = cycle - 1; i < j; i++, j--) {
            appendInnerRow(builder, s, cycle, i, j);
        }
        appendOuterRow(builder, s, cycle, cycle / 2);
        return builder.toString();
    }

    private static void appendOuterRow(final StringBuilder builder,
                                       final String s,
                                       final int cycle,
                                       final int offset) {
        for (int i = offset; i < s.length(); i += cycle) {
            builder.append(s.charAt(i));
        }
    }

    private static void appendInnerRow(final StringBuilder builder,
                                       final String s,
                                       final int cycle,
                                       final int downwardOffset,
                                       final int upwardOffset) {
        int i = 0;
        while (i + upwardOffset < s.length()) {
            builder.append(s.charAt(i + downwardOffset));
            builder.append(s.charAt(i + upwardOffset));
            i += cycle;
        }

        if (i + downwardOffset < s.length()) {
            builder.append(s.charAt(i + downwardOffset));
        }
    }
}
