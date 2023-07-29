package main.com.sumit.coding.topics.stack;

import java.util.Stack;

public class DeleteMiddleElementOfStack {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);

        int sizeOfStack = myStack.size();
        if (sizeOfStack == 1) {
            System.out.println(myStack.peek());
        } else {
            Stack<Integer> modified = deleteMid(myStack, sizeOfStack, 0);

            while (!modified.isEmpty()) {
                System.out.print(modified.peek() + " ");
                modified.pop();
            }
            System.out.println();
        }
    }

    private static Stack<Integer> deleteMid(Stack<Integer> s, int sizeOfStack, int current) {

        if (current == sizeOfStack / 2) {
            s.pop();
            return s;
        }

        int x = s.peek();
        s.pop();
        current += 1;

        // recursively call deleteMid
        s = deleteMid(s, sizeOfStack, current);
        s.push(x);

        return s;
    }
}
