package main.com.sumit.coding.leetcode.Oct20;

import java.util.Arrays;
import java.util.Stack;

/*
* URL :
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3502/
* */
public class Problem21 {

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        // int[] asteroids = {10, 2, -5};
        System.out.println(Arrays.toString(new Problem21().asteroidCollision(asteroids)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) stack.pop();

                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int last = result.length - 1; last >= 0; --last) {
            result[last] = stack.pop();
        }
        return result;
    }
}
