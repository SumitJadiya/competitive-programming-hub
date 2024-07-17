package main.com.sumit.coding.topics.linkedList;

import static main.com.sumit.coding.topics.linkedList.ListNode.printLinkedList;

/*
 * Given a singly linked list with n nodes and two positions, left and right,
 * the objective is to reverse the nodes of the list from left to right.
 * Return the modified list.
 * Constraints:
 * - 1 ≤ n ≤ 500
 * - −5000 ≤ node.data ≤ 5000
 * - 1≤ left ≤ right ≤ n
 *
 * Below are the steps of the algorithm:
 *
 * - We initialize a dummy node, which will be helpful in scenarios where the reversal of the sublist starts from the head of the list.
 * - We set the next node of dummy to point to the head of the list.
 * - We initialize a pointer, prev, to the dummy node. This pointer will help us reconnect the sublist to the entire list after it has been reversed.
 * - We use a loop to traverse the list with the prev pointer and until it reaches the node immediately before the sublist to be reversed.
 * - We initialize a curr pointer, which points to the node next to prev.
 * - Another loop is used to reverse the sublist. This loop iterates right - left times, which is the number of nodes in the sublist minus one:
 *       - We set next_node to curr.next, representing the node to be moved to the front of the reversed sublist.
 *       - We update curr.next to next_node.next, effectively removing next_node from its current position in the sublist.
 *       - We set next_node.next to prev.next, inserting next_node at the beginning of the reversed sublist.
 *       - We update prev.next to next_node, adjusting the pointer to next_node for the next iteration.
 * - Finally, we return dummy.next, which is the head of the modified linked list.
 * */
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
