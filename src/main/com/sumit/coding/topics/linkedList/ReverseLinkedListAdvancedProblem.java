package main.com.sumit.coding.topics.linkedList;

import static main.com.sumit.coding.topics.linkedList.ListNode.printLinkedList;

public class ReverseLinkedListAdvancedProblem {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++)
            prev = prev.next;

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        printLinkedList(reverseBetween(node, 2, 4));
    }
}
