package main.com.sumit.coding.google.LinkedList;

/*
    Problem URL : https://leetcode.com/problems/add-two-numbers/

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        printLinkedList(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode preHead = new ListNode(0);
        ListNode dummy = preHead;

        while (l1 != null || l2 != null || add != 0) {

            int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            add += temp;
            dummy.next = new ListNode(add % 10);
            dummy = dummy.next;

            add /= 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return preHead.next;
    }

    private static void printLinkedList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
