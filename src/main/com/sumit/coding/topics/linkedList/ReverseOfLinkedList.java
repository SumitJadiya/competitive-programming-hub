package main.com.sumit.coding.topics.linkedList;

/*
 * Problem URL : https://leetcode.com/problems/reverse-linked-list/
 * */
public class ReverseOfLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode reversedLinkedList = reverseLinkedList(node);

        ListNode.printLinkedList(reversedLinkedList);
    }

    private static ListNode reverseLinkedList(ListNode head) {

        ListNode currPtr = null;
        ListNode nextPtr = head;
        ListNode prevPtr = null;

        while (nextPtr != null) {
            currPtr = nextPtr;
            nextPtr = currPtr.next;
            currPtr.next = prevPtr;
            prevPtr = currPtr;
        }
        head = currPtr;

        return head;
    }
}
