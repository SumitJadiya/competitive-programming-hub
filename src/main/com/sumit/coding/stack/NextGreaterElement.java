package main.com.sumit.coding.stack;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 4};

        printNextGreater(arr, arr.length);

    }

    public static void printNextGreater(int[] arr, int size) {
        Map<Integer, Integer> data = new TreeMap<>();
        Stack<Integer> stack = new Stack<>();
        Boolean flag;

        int curr;
        stack.add(arr[0]);

        for (int i = 0; i < size; i++) {
            data.put(arr[i], -1);
        }

        for (int i = 1; i < size; i++) {
            flag = true;
            while (!stack.empty() && flag) {
                curr = stack.peek();
                if (curr < arr[i]) {
                    stack.pop();
                    data.put(curr, arr[i]);
                } else {
                    flag = false;
                }
            }
            stack.add(arr[i]);
        }

        printElements(arr, data);
    }

    private static void printElements(int[] arr, Map<Integer, Integer> data) {

        for (int num : arr) {
            System.out.print(data.get(num) + " ");
        }
    }
}

