package me.guva.leetcode.find_median_sorted_arrays;

class Solution {
    public static double findMedianSortedArrays(final int[] nums1,
                                                final int[] nums2) {
        final int[][] orderedArrays = sortArraysByLength(nums1, nums2);
        final int[] shortNums = orderedArrays[0];
        final int[] longNums = orderedArrays[1];

        final int shortMedianIndex = indexOfMedian(shortNums, longNums);
        return getMedian(shortNums, shortMedianIndex, longNums);
    }

    private static int[][] sortArraysByLength(final int[] nums1,
                                              final int[] nums2) {
        if (nums1.length < nums2.length) {
            return new int[][] {nums1, nums2};
        } else {
            return new int[][] {nums2, nums1};
        }
    }

    private static int indexOfMedian(final int[] shortNums,
                                     final int[] longNums) {
        final int start = 0;
        final int end = shortNums.length - 1;
        return binarySearchForMedian(shortNums, start, end, longNums);
    }

    private static int binarySearchForMedian(final int[] nums,
                                             final int start,
                                             final int end,
                                             final int[] complements) {
        if (start > end) {
            return -start - 1;
        }

        final int mid = (start + end) / 2;
        if (greaterThanMedian(nums, mid, complements)) {
            return binarySearchForMedian(nums, start, mid - 1, complements);
        } else if (lessThanMedian(nums, mid, complements)) {
            return binarySearchForMedian(nums, mid + 1, end, complements);
        } else {
            return mid;
        }
    }

    private static boolean greaterThanMedian(final int[] nums,
                                             final int index,
                                             final int[] complements) {
        final int nextComplementIndex = nextComplementIndex(nums,
                                                            index,
                                                            complements);
        if (nextComplementIndex >= complements.length) {
            return false;
        }

        final int candidateMedian = nums[index];
        final int nextComplement = complements[nextComplementIndex];
        return nextComplement < candidateMedian;
    }

    private static boolean lessThanMedian(final int[] nums,
                                          final int index,
                                          final int[] complements) {
        // Note that prevComplementIndex >= 0 always because we only search for
        // the upper median and binary search over the shorter array.
        final int prevComplementIndex = prevComplementIndex(nums,
                                                            index,
                                                            complements);
        final int candidateMedian = nums[index];
        final int prevComplement = complements[prevComplementIndex];
        return prevComplement > candidateMedian;
    }

    private static int nextComplementIndex(final int[] nums,
                                           final int index,
                                           final int[] complements) {
        final int totalLength = nums.length + complements.length;
        return (totalLength / 2) - index;
    }

    private static int prevComplementIndex(final int[] nums,
                                           final int index,
                                           final int[] complements) {
        return nextComplementIndex(nums, index, complements) - 1;
    }

    private static int convertIndex(final int[] nums,
                                    final int[] complements,
                                    final int complementMedianIndex) {
        final int prevComplements = -complementMedianIndex - 1;
        final int totalLength = nums.length + complements.length;
        return totalLength / 2 - prevComplements;
    }

    private static double getMedian(final int[] nums,
                                    final int index,
                                    final int[] complements) {
        if (index < 0) {
            final int complementIndex = convertIndex(complements, nums, index);
            return getMedian(complements, complementIndex, nums);
        }

        final int length = nums.length + complements.length;
        final int median = nums[index];
        if (length % 2 == 1) {
            return median * 1.0;
        } else {
            final int prevNum = getPrevNum(nums, index, complements);
            return (median + prevNum) / 2.0;
        }
    }

    private static int getPrevNum(final int[] nums,
                                  final int index,
                                  final int[] complements) {
        final int prevIndex = index - 1;
        final int prevComplementIndex = prevComplementIndex(nums,
                                                            index,
                                                            complements);
        if (prevIndex < 0) {
            return complements[prevComplementIndex];
        } else if (prevComplementIndex < 0) {
            return nums[prevIndex];
        } else {
            final int prevNum = nums[prevIndex];
            final int prevComplement = complements[prevComplementIndex];
            return Math.max(prevNum, prevComplement);
        }
    }
}
