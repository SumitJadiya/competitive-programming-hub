package main.com.sumit.coding.topics.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Design a stack-like data structure. You should be able to push elements to this data structure and pop elements with maximum frequency.
 *
 * You’ll need to implement the FreqStack class that should consist of the following:
 * FreqStack: This is a class used to declare a frequency stack.
 * Push(value): This is used to push an integer data onto the top of the stack.
 * Pop(): This is used to remove and return the most frequent element in the stack.
 *
 * Note: If there is a tie for the most frequent element, then the most recently pushed element is removed and returned.
 * */
public class MaximumFrequencyStackProblem {

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(6);
        stack.push(8);
        stack.push(9);
        stack.push(4);
        stack.push(8);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class FreqStack {
    Map<Integer, Integer> frequencyMap;
    Map<Integer, Stack<Integer>> stackMap;
    int maxFrequency;

    public FreqStack() {
        frequencyMap = new HashMap<>();
        stackMap = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int value) {
        int freq = frequencyMap.getOrDefault(value, 0) + 1;
        frequencyMap.put(value, freq);

        maxFrequency = Math.max(freq, maxFrequency);

        stackMap.computeIfAbsent(freq, k -> new Stack<>()).push(value);
    }

    public int pop() {
        Stack<Integer> maxFreqStack = stackMap.get(maxFrequency);
        int value = maxFreqStack.pop();

        if (maxFreqStack.isEmpty()) {
            stackMap.remove(maxFrequency);
            maxFrequency--;
        }
        frequencyMap.put(value, frequencyMap.get(value) - 1);

        return value;
    }
}
