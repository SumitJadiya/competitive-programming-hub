package com.sumit.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInterfaceImplementationUsingLinkedList {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            queue.add(i);

        System.out.println("Elements of Queue - " + queue);

        int removedElement = queue.remove();

        System.out.println("Removed Element = " + removedElement);

        System.out.println("Elements of Queue - " + queue);

        int head = queue.peek();
        System.out.println("Head Element = " + head);

        int size = queue.size();
        System.out.println("Size = " + size);
    }
}
