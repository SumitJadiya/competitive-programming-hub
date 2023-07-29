package main.com.sumit.coding.topics.stack;

import java.util.ArrayList;
import java.util.List;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

public class MinStackProblem {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}


class MinStack {
    List<Integer> stack;
    List<Integer> minValue;

    public MinStack() {
        stack = new ArrayList<>();
        minValue = new ArrayList<>();
    }

    public void push(int val) {

        if (minValue.isEmpty() || val <= minValue.get(minValue.size() - 1))
            minValue.add(val);

        stack.add(val);
    }

    public void pop() {
        // System.out.println((minValue.get(minValue.size() - 1) == stack.get(stack.size() - 1)));
        if (!minValue.isEmpty() && (minValue.get(minValue.size() - 1)).equals(stack.get(stack.size() - 1)))
            minValue.remove(minValue.size() - 1);

        if (!stack.isEmpty())
            stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return (minValue.isEmpty()) ? 0 : minValue.get(minValue.size() - 1);
    }
}
