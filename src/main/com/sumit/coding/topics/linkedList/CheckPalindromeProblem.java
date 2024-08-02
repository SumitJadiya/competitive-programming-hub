package main.com.sumit.coding.topics.linkedList;

import static main.com.sumit.coding.topics.linkedList.ListNode.reverse;

/*
 * Problem URL : https://leetcode.com/problems/palindrome-linked-list/
 * */
public class CheckPalindromeProblem {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverse(slow);

        while (secondHalfHead != null) {
            if (secondHalfHead.val != firstHalfHead.val)
                return false;

            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;
        }

        return true;
    }
}
