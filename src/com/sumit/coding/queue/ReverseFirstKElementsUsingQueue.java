package com.sumit.coding.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsUsingQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);

        printQueue(reverseKElements(queue, 5));
    }

    private static Queue<Integer> reverseKElements(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 1; i <= queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }

        return queue;
    }

    private static void printQueue(Queue<Integer> outputQueue) {

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.peek() + " ");
            outputQueue.remove();
        }
    }
}
