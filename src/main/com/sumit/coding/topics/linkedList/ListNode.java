package com.sumit.coding.topics.linkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    protected static void printLinkedList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    protected static ListNode reverse(ListNode head) {
        ListNode curr;
        ListNode prev = null;
        ListNode next = head;

        while (next != null) {
            curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
        }

        return prev;
    }

}
