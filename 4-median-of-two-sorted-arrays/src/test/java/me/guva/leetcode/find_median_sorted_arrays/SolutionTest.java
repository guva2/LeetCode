package me.guva.leetcode.find_median_sorted_arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * The solution that we are testing.
     */
    private final Solution solution = new Solution();

    @Test
    void firstExampleTest() {
        final int[] nums1 = new int[] {1, 3};
        final int[] nums2 = new int[] {2};
        final double expectedOutput = 2.0;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final int[] nums1 = new int[] {1, 2};
        final int[] nums2 = new int[] {3, 4};
        final double expectedOutput = 2.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final int[] nums1 = new int[] {2, 2, 4, 4};
        final int[] nums2 = new int[] {2, 2, 4, 4};
        final double expectedOutput = 3.0;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void firstArrayEmptyTest() {
        final int[] nums1 = new int[] {1, 2, 3, 4, 5, 6};
        final int[] nums2 = new int[] {};
        final double expectedOutput = 3.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void secondArrayEmptyTest() {
        final int[] nums1 = new int[] {};
        final int[] nums2 = new int[] {1, 2, 3, 4, 5, 6};
        final double expectedOutput = 3.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void equalLengthFirstArrayPrecedesSecondArray() {
        final int[] nums1 = new int[] {1, 2, 3, 4, 5};
        final int[] nums2 = new int[] {6, 7, 8, 9, 10};
        final double expectedOutput = 5.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void equalLengthFirstArraySucceedsSecondArray() {
        final int[] nums1 = new int[] {6, 7, 8, 9, 10};
        final int[] nums2 = new int[] {1, 2, 3, 4, 5};
        final double expectedOutput = 5.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void equalLengthInterleavingArraysTest() {
        final int[] nums1 = new int[] {1, 3, 5, 7, 9};
        final int[] nums2 = new int[] {2, 4, 6, 8, 10};
        final double expectedOutput = 5.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void singleValueArraysTest() {
        final int[] nums1 = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2};
        final int[] nums2 = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2,
                                       2, 2, 2, 2, 2, 2, 2, 2, 2};
        final double expectedOutput = 2.0;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void shortArrayPrecedesLongArrayOddTest() {
        final int[] nums1 = new int[] {1, 2, 3};
        final int[] nums2 = new int[] {4, 5, 6, 7, 8, 9};
        final double expectedOutput = 5.0;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void shortArrayPrecedesLongArrayEvenTest() {
        final int[] nums1 = new int[] {1, 2, 3};
        final int[] nums2 = new int[] {4, 5, 6, 7, 8, 9, 10};
        final double expectedOutput = 5.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void longArrayPrecedesShortArrayOddTest() {
        final int[] nums1 = new int[] {1, 2, 3};
        final int[] nums2 = new int[] {4, 5, 6, 7, 8, 9};
        final double expectedOutput = 5.0;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }

    @Test
    void longArrayPrecedesShortArrayEvenTest() {
        final int[] nums1 = new int[] {1, 2, 3};
        final int[] nums2 = new int[] {4, 5, 6, 7, 8, 9, 10};
        final double expectedOutput = 5.5;
        final double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedOutput, output);
    }
}
