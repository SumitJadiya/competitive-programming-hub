package main.com.sumit.coding.linkedList;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(6);
        node.next.next = new Node(6);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        int val = 6;

        Node finalNode = new RemoveLinkedListElements().removeElements(node, val);
        printLinkedList(finalNode);
    }

    private static void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public Node removeElements(Node head, int val) {
        Node temp = new Node(0);
        temp.next = head;
        Node prev = temp;

        while (head != null) {
            if (head.val == val)
                prev.next = head.next;
            else
                prev = head;

            head = head.next;
        }
        return temp.next;
    }
}
