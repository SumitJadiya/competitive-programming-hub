package com.sumit.coding.queue;

class MyQueue {

    int capacity;
    int size;
    int front;
    int rear;
    int[] arr;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = this.capacity - 1;
        arr = new int[this.capacity];
    }

    private boolean isEmpty() {
        return (this.size == 0);
    }

    private boolean isFull() {
        return (this.size == this.capacity);
    }

    public int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return arr[this.front];
    }

    public int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return arr[this.rear];
    }

    public void enqueue(int item) {
        if (isFull())
            return;

        this.rear = ((this.rear + 1) % (this.capacity));
        arr[this.rear] = item;
        this.size++;
    }

    public int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int item = arr[this.front];
        this.front = ((this.front + 1) % (this.capacity));
        this.size--;

        return item;
    }

    public void printQueue() {

        if (this.front == this.rear)
            System.out.println("Queue is Empty");

        int i = this.front;
        while (i < this.rear + 1) {
            System.out.print(this.arr[i] + " ");
            i++;
        }

        System.out.println();
    }
}

public class QueueImplementationUsingArray {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(7);
        queue.dequeue();
        queue.printQueue();

        System.out.println("Front Item = " + queue.front());
        System.out.println("Rear Item = " + queue.rear());
    }

}
