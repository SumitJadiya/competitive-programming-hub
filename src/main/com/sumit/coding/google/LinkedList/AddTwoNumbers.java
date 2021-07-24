package main.com.sumit.coding.google.LinkedList;

/*
    Problem URL : https://leetcode.com/problems/add-two-numbers/

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Solution : O(N)
*/
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode.printLinkedList(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode(0);
        ListNode dummy = preHead;

        while (l1 != null || l2 != null || carry != 0) {
            carry += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            dummy.next = new ListNode(carry % 10);
            dummy = dummy.next;

            carry /= 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return preHead.next;
    }
}
