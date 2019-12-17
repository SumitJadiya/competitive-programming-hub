package com.sumit.coding.queue;

import java.util.Stack;

class QueueOperationsUsingTwoStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int val) {
        if (s2.isEmpty() && s1.isEmpty())
            s1.push(val);
        else if (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(val);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public int dequeue() {

        if (s1.isEmpty())
            return -1;

        return s1.pop();
    }

    public void print() {
        while (!s1.isEmpty())
            System.out.print(s1.pop() + " ");
    }

}

public class QueueUsingTwoStacks {

    public static void main(String[] args) {

        QueueOperationsUsingTwoStacks queueOperationsUsingTwoStacks = new QueueOperationsUsingTwoStacks();
        queueOperationsUsingTwoStacks.enqueue(10);
        queueOperationsUsingTwoStacks.enqueue(20);
        queueOperationsUsingTwoStacks.enqueue(30);
        queueOperationsUsingTwoStacks.enqueue(40);
        queueOperationsUsingTwoStacks.enqueue(50);
        queueOperationsUsingTwoStacks.dequeue();
        queueOperationsUsingTwoStacks.enqueue(60);
        queueOperationsUsingTwoStacks.enqueue(70);

        queueOperationsUsingTwoStacks.print();
    }

}
