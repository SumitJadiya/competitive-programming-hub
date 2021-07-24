package main.com.sumit.coding.google.LinkedList;

/*
 * Problem URL : https://leetcode.com/problems/merge-two-sorted-lists/
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * */
public class MergeTwoListProblem {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);

        ListNode.printLinkedList(mergeTwoLists(l1, l2));
    }

    /*
     * Time Complexity O(N+M)
     * Space Complexity O(1)
     * */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode preHead = new ListNode(0);
        ListNode temp = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null) ? l2 : l1;

        return preHead.next;
    }
}
