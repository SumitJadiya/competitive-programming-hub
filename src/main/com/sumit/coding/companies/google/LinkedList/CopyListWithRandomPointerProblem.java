package main.com.sumit.coding.companies.google.LinkedList;

import java.util.HashMap;

/*
*
* */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public static void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

public class CopyListWithRandomPointerProblem {

    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.random = new Node(0);
        node.next.next = new Node(11);
        node.next.next.random = new Node(4);
        node.next.next.next = new Node(10);
        node.next.next.next.random = new Node(2);
        node.next.next.next.next = new Node(1);
        node.next.next.next.next.random = new Node(0);

        Node.printLinkedList(copyRandomList_one(node));
        System.out.println();
        Node.printLinkedList(copyRandomList_two(node));
    }

    /* Time Complexity : O(n) Space Complexity : O(n) */
    public static Node copyRandomList_one(Node head) {
        if (head == null) return head;
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            hashMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        for (Node key : hashMap.keySet()) {
            Node newNode = hashMap.get(key);
            newNode.next = hashMap.get(key.next);
            newNode.random = hashMap.get(key.random);
        }

        return hashMap.get(head);
    }

    /*
     * Steps:
     * 1. convert [A->B->C] to [A->A'->B->B'->C->C']
     * 2. move the random pointers in A', B', C' to next pointer
     * 3. Remove [A->B->C] to reduce [A'->B'->C']
     *
     * Time Complexity : O(n) Space Complexity : O(1)
     * */
    public static Node copyRandomList_two(Node head) {

        if (head == null) return head;

        Node temp = head;

        // step 1
        while (temp != null) {
            Node next = temp.next;
            Node random = temp.random;
            temp.next = new Node(temp.val, next, random);

            temp = temp.next.next;
        }

        // step 2
        temp = head;

        while (temp != null) {
            if (temp.next.random != null)
                temp.next.random = temp.next.random.next;

            temp = temp.next.next;
        }

        // step 3
        temp = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (copy.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        temp.next = temp.next.next;

        return copyHead;
    }
}
