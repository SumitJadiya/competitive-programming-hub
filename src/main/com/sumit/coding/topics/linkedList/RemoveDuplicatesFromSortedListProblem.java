package main.com.sumit.coding.topics.linkedList;

/*
 * Problem URL : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * */
public class RemoveDuplicatesFromSortedListProblem {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(6);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next = new ListNode(7);

        ListNode.printLinkedList(deleteDuplicates(node));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;

        while (node != null && node.next != null) {

            if (node.val == node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }

        return head;
    }


}


