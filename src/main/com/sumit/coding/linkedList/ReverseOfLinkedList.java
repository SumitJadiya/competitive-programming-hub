package main.com.sumit.coding.linkedList;

class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class ReverseOfLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node reversedLinkedList = reverseLinkedList(node);

        printLinkedList(reversedLinkedList);
    }

    private static Node reverseLinkedList(Node head) {

        Node currPtr = null;
        Node nextPtr = head;
        Node prevPtr = null;

        while (nextPtr != null) {
            currPtr = nextPtr;
            nextPtr = currPtr.next;
            currPtr.next = prevPtr;
            prevPtr = currPtr;
        }
        head = currPtr;

        return head;
    }

    private static void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
