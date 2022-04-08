package me.guva.leetcode.two_sum;

import java.util.Map;
import java.util.HashMap;

final class Solution {
    private Solution() { }

    public static int[] twoSum(final int[] nums, final int target) {
        final Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            final int targetDifference = target - num;
            final Integer complementIndex = indices.get(targetDifference);

            if (complementIndex == null) {
                indices.put(num, i);
            } else {
                return new int[] {complementIndex, i};
            }
        }
        throw new IllegalArgumentException("No pair of nums sum to target.");
    }
}
