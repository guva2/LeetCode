package me.guva.leetcode.max_area;

class Solution {
    public static int maxArea(final int[] height) {
        int output = 0;

        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            final int length = right - left;
            final int leftHeight = height[left];
            final int rightHeight = height[right];

            if (leftHeight < rightHeight) {
                output = Math.max(output, leftHeight * length);
                left++;
            } else {
                output = Math.max(output, rightHeight * length);
                right--;
            }
        }

        return output;
    }
}
