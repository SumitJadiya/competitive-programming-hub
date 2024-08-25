package com.sumit.coding.topics.linkedList;

/*
 * Problem URL : https://leetcode.com/problems/remove-linked-list-elements/
 * */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(6);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        int val = 6;

        ListNode finalNode = new RemoveLinkedListElements().removeElements(node, val);
        ListNode.printLinkedList(finalNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        while (head != null) {
            if (head.val == val)
                prev.next = head.next;
            else
                prev = head;

            head = head.next;
        }
        return temp.next;
    }
}
