package main.com.sumit.coding.companies.google.LinkedList;

/*
 * Problem URL : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * */
public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        int n = 2;

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode.printLinkedList(removeNthFromEnd(node, n));
    }

    /*
     * O(L) time complexity
     * O(1) space complexity
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        for (int i = 0; i <= n; i++) firstPtr = firstPtr.next;

        while (firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        secondPtr.next = secondPtr.next.next;
        return dummy.next;
    }
}
