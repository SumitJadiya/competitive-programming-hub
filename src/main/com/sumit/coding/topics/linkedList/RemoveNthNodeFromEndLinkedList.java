package com.sumit.coding.topics.linkedList;

import static com.sumit.coding.topics.linkedList.ListNode.printLinkedList;

public class RemoveNthNodeFromEndLinkedList {

    public static void main(String[] args) {
        int n = 2;
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        printLinkedList(removeNthFromEnd(node, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++)
            fast = fast.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
