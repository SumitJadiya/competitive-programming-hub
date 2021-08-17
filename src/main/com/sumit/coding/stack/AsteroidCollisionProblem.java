package main.com.sumit.coding.stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * Problem URL : https://leetcode.com/problems/asteroid-collision/
 * */
public class AsteroidCollisionProblem {

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(new AsteroidCollisionProblem().asteroidCollision(asteroids)));
    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <= 1) return asteroids;  // Handling Corner cases

        Stack<Integer> stack = new Stack<>();
        for (int asteriod : asteroids) {
            if (asteriod > 0) // Pushing all +ve asteroids
                stack.push(asteriod);
            else {
                // Remove all positive asteroids before our current asteroid
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(asteriod))
                    stack.pop();
                // Checking if the stack is empty or the recent asteriod is negative!
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteriod);
                    // If recent asteriod <= our asteriod, We broke our outer loop if equal we pop it.
                else if (stack.peek() == Math.abs(asteriod))
                    stack.pop();
            }
        }

        int[] output = new int[stack.size()];
        for (int i = output.length - 1; i >= 0; i--)
            output[i] = stack.pop();

        return output;
    }
}
