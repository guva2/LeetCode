package me.guva.leetcode.add_two_numbers;

final class Solution {
    /**
     * The problem is framed in base 10.
     */
    private static final int BASE = 10;

    private Solution() { }

    public static ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        final ListNode header = new ListNode(0);
        ListNode outputNode = header;
        ListNode firstInputNode = l1;
        ListNode secondInputNode = l2;
        int carry = 0;
        while (firstInputNode != null || secondInputNode != null || carry > 0) {
            final int sum = sum(firstInputNode, secondInputNode, carry);
            final int value = sum % BASE;
            carry = sum / BASE;
            outputNode = createNextNode(outputNode, value);
            firstInputNode = getNextNode(firstInputNode);
            secondInputNode = getNextNode(secondInputNode);
        }
        return header.next;
    }

    private static ListNode createNextNode(final ListNode node,
                                           final int value) {
        final ListNode nextNode = new ListNode(value);
        node.next = nextNode;
        return nextNode;
    }

    private static ListNode getNextNode(final ListNode node) {
        if (node == null) {
            return null;
        }
        return node.next;
    }

    private static int getNodeValue(final ListNode node) {
        return node == null ? 0 : node.val;
    }

    private static int sum(final ListNode firstNode,
                           final ListNode secondNode,
                           final int carry) {
        final int firstValue = getNodeValue(firstNode);
        final int secondValue = getNodeValue(secondNode);
        return firstValue + secondValue + carry;
    }
}
