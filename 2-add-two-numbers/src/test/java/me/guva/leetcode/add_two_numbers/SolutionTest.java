package me.guva.leetcode.add_two_numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SolutionTest {
    private ListNode createList(final int[] digits) {
        ListNode output = null;
        for (int i = digits.length - 1; i >= 0; i--) {
            output = new ListNode(digits[i], output);
        }
        return output;
    }

    private void assertListEquals(final ListNode expectedOutputRoot,
                                  final ListNode outputRoot) {
        ListNode expectedOutputNode = expectedOutputRoot;
        ListNode outputNode = outputRoot;
        while (expectedOutputNode != null && outputNode != null) {
            assertEquals(expectedOutputNode.val, outputNode.val);
            expectedOutputNode = expectedOutputNode.next;
            outputNode = outputNode.next;
        }
        assertNull(expectedOutputNode);
        assertNull(outputNode);
    }

    @Test
    void firstExampleTest() {
        final int[] firstInputArray = new int[] {2, 4, 3};
        final int[] secondInputArray = new int[] {5, 6, 4};
        final int[] expectedOutputArray = new int[] {7, 0, 8};

        final ListNode l1 = createList(firstInputArray);
        final ListNode l2 = createList(secondInputArray);
        final ListNode expectedOutput = createList(expectedOutputArray);

        final ListNode output = Solution.addTwoNumbers(l1, l2);
        assertListEquals(expectedOutput, output);
    }

    @Test
    void secondExampleTest() {
        final int[] firstInputArray = new int[] {0};
        final int[] secondInputArray = new int[] {0};
        final int[] expectedOutputArray = new int[] {0};

        final ListNode l1 = createList(firstInputArray);
        final ListNode l2 = createList(secondInputArray);
        final ListNode expectedOutput = createList(expectedOutputArray);

        final ListNode output = Solution.addTwoNumbers(l1, l2);
        assertListEquals(expectedOutput, output);
    }

    @Test
    void thirdExampleTest() {
        final int[] firstInputArray = new int[] {9, 9, 9, 9, 9, 9, 9};
        final int[] secondInputArray = new int[] {9, 9, 9, 9};
        final int[] expectedOutputArray = new int[] {8, 9, 9, 9, 0, 0, 0, 1};

        final ListNode l1 = createList(firstInputArray);
        final ListNode l2 = createList(secondInputArray);
        final ListNode expectedOutput = createList(expectedOutputArray);

        final ListNode output = Solution.addTwoNumbers(l1, l2);
        assertListEquals(expectedOutput, output);
    }

    @Test
    void longerFirstNumberTest() {
        final int[] firstInputArray = new int[] {1, 1, 1, 1, 1, 1};
        final int[] secondInputArray = new int[] {1, 1, 1};
        final int[] expectedOutputArray = new int[] {2, 2, 2, 1, 1, 1};

        final ListNode l1 = createList(firstInputArray);
        final ListNode l2 = createList(secondInputArray);
        final ListNode expectedOutput = createList(expectedOutputArray);

        final ListNode output = Solution.addTwoNumbers(l1, l2);
        assertListEquals(expectedOutput, output);
    }

    @Test
    void longerSecondNumberTest() {
        final int[] firstInputArray = new int[] {1, 1, 1};
        final int[] secondInputArray = new int[] {1, 1, 1, 1, 1, 1};
        final int[] expectedOutputArray = new int[] {2, 2, 2, 1, 1, 1};

        final ListNode l1 = createList(firstInputArray);
        final ListNode l2 = createList(secondInputArray);
        final ListNode expectedOutput = createList(expectedOutputArray);

        final ListNode output = Solution.addTwoNumbers(l1, l2);
        assertListEquals(expectedOutput, output);
    }

    @Test
    void carryDigitTest() {
        final int[] firstInputArray = new int[] {5};
        final int[] secondInputArray = new int[] {5};
        final int[] expectedOutputArray = new int[] {0, 1};

        final ListNode l1 = createList(firstInputArray);
        final ListNode l2 = createList(secondInputArray);
        final ListNode expectedOutput = createList(expectedOutputArray);

        final ListNode output = Solution.addTwoNumbers(l1, l2);
        assertListEquals(expectedOutput, output);
    }
}
