package main.com.sumit.coding.topics.queue;

/*
Problem statement : https://leetcode.com/problems/open-the-lock/

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".

Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".

Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.

Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1

*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLockProblem {

    public static void main(String[] args) {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println(new OpenTheLockProblem().openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {

        // create a set to add deadlines
        Set<String> deadendSet = new HashSet(Arrays.asList(deadends));
        // queue will keep all the combinations
        Queue<String> queue = new LinkedList<>();
        // this will take care of all the visited nodes
        Set<String> visited = new HashSet<>();
        // track the level of graph
        int level = 0;

        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int length = queue.size();
            while (length > 0) {
                String currentNode = queue.poll();

                // check if we're stuck in deadend
                if (deadendSet.contains(currentNode)) {
                    length--;
                    continue;
                }

                // return if target is achieved
                if (currentNode.equals(target)) return level;

                StringBuffer buffer = new StringBuffer(currentNode);
                for (int i = 0; i < 4; i++) {
                    char currentPosition = buffer.charAt(i);

                    // keep stroring all the combinations for 4 digit chars
                    StringBuffer s1 = (new StringBuffer()).append(buffer.substring(0, i)).append((currentPosition == '0' ? 9 : (currentPosition - '0' - 1))).append(buffer.substring(i + 1));
                    StringBuffer s2 = (new StringBuffer()).append(buffer.substring(0, i)).append((currentPosition == '9' ? 0 : (currentPosition - '0' + 1))).append(buffer.substring(i + 1));

                    String stringOne = s1.toString();
                    String stringTwo = s2.toString();

                    // insert into queue if the strings are not yet visited and not deadend
                    if (!deadendSet.contains(stringOne) && !visited.contains(stringOne)) {
                        queue.offer(stringOne);
                        visited.add(stringOne);
                    }
                    if (!deadendSet.contains(stringTwo) && !visited.contains(stringTwo)) {
                        queue.offer(stringTwo);
                        visited.add(stringTwo);
                    }
                }
                length--;
            }
            ++level;
        }

        return -1;
    }
}
