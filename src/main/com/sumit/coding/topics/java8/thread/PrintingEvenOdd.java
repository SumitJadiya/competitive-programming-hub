package com.sumit.coding.topics.java8.thread;

/*
 * 2 threads
 * 1 -> Printing odd numbers
 * 2 -> printing even numbers
 *
 * total 50 numbers.
 *
 * use lambda -> thread -> execute ->
 * */
public class PrintingEvenOdd {
    private static final int MAX = 50;
    private static int counter = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable printEven = () -> {
            while (counter < MAX) {
                synchronized (lock) {
                    if (counter % 2 == 0) {
                        System.out.println("Even: " + counter);
                        counter++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException wx) {
                            System.out.println(wx.getMessage());
                        }
                    }
                }
            }
        };
        Runnable printOdd = () -> {
            while (counter < MAX) {
                synchronized (lock) {
                    if (counter % 2 != 0) {
                        System.out.println("Odd: " + counter);
                        counter++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException wx) {
                            System.out.println(wx.getMessage());
                        }
                    }
                }
            }
        };


        Thread evenThread = new Thread(printEven);
        Thread oddThread = new Thread(printOdd);

        oddThread.start();
        evenThread.start();
    }

}
