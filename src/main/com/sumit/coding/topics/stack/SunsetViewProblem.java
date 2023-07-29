package main.com.sumit.coding.topics.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SunsetViewProblem {

    public static void main(String[] args) {
        int[] building = {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        System.out.println(new SunsetViewProblem().sunsetViews(building, direction));
    }

    public List<Integer> sunsetViews(int[] buildings, String direction) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int length = buildings.length;

        if (length <= 0)
            return new ArrayList<>();

        if (direction.equals("EAST")) {
            int maxSoFar = buildings[length - 1];
            stack.push(length - 1);

            // O(n)
            for (int i = length - 2; i >= 0; i--) {
                if (maxSoFar < buildings[i]) {
                    maxSoFar = buildings[i];
                    stack.push(i);// O(1)
                }
            }
            // O(n)
            while (!stack.isEmpty())
                result.add(stack.pop()); // O(1)
        } else if (direction.equals("WEST")) {
            int maxSoFar = buildings[0];
            result.add(0);
            // O(n)
            for (int i = 1; i < buildings.length; i++) {
                if (maxSoFar < buildings[i]) {
                    maxSoFar = buildings[i];
                    result.add(i);// O(1)
                }
            }
        }

        return result;
    }
}
