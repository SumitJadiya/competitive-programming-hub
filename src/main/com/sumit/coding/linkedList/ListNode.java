package main.com.sumit.coding.linkedList;

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
}
