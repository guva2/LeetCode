package me.guva.leetcode.two_sum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
class SolutionTest {
    @Test
    void firstExampleTest() {
        final int[] nums = new int[]{1, 2};
        final int target = 3;
        final int[] expectedOutput = new int[]{0, 1};
        final int[] indices = Solution.twoSum(nums, target);
        Arrays.sort(indices);
        assertArrayEquals(expectedOutput, indices);
    }

    @Test
    void secondExampleTest() {
        final int[] nums = new int[]{3, 2, 4};
        final int target = 6;
        final int[] expectedOutput = new int[]{1, 2};
        final int[] indices = Solution.twoSum(nums, target);
        Arrays.sort(indices);
        assertArrayEquals(expectedOutput, indices);
    }

    @Test
    void thirdExampleTest() {
        final int[] nums = new int[]{3, 3};
        final int target = 6;
        final int[] expectedOutput = new int[]{0, 1};
        final int[] indices = Solution.twoSum(nums, target);
        Arrays.sort(indices);
        assertArrayEquals(expectedOutput, indices);
    }

    @Test
    void sortedArrayTest() {
        final int[] nums = new int[]{1, 2, 4, 8, 16};
        final int target = 17;
        final int[] expectedOutput = new int[]{0, 4};
        final int[] indices = Solution.twoSum(nums, target);
        Arrays.sort(indices);
        assertArrayEquals(expectedOutput, indices);
    }

    @Test
    void negativeNumbersTest() {
        final int[] nums = new int[]{-1, 2, 4, 8, -16};
        final int target = -17;
        final int[] expectedOutput = new int[]{0, 4};
        final int[] indices = Solution.twoSum(nums, target);
        Arrays.sort(indices);
        assertArrayEquals(expectedOutput, indices);
    }

    @Test
    void invalidInputTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            final int[] nums = new int[]{-1, 2, 4, 8, -16};
            final int target = 200;
            Solution.twoSum(nums, target);
        });
    }
}
