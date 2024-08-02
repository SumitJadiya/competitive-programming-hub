package main.com.sumit.coding.topics.linkedList;

public class MergeTwoSortedListProblem {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);
        node1.next.next.next = new ListNode(7);
        node1.next.next.next.next = new ListNode(8);
        node1.next.next.next.next.next = new ListNode(9);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(6);

        ListNode.printLinkedList(mergeTwoLists(node1, node2));

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // Create a dummy head to help simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the two lists while both have nodes remaining
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
