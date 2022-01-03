package main.com.sumit.coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * URL : https://leetcode.com/explore/interview/card/adobe/483/array-and-strings/2503/
 * Positions of Large Groups
 *
 * Input: s = "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Explanation: The large groups are "ddd", "eeee", and "bbb".
 */
public class LargeGroupPositionsProblem {

    public static void main(String[] args) {

        String str = "abcdddeeeeaabbbcd";
        System.out.println(new LargeGroupPositionsProblem().largeGroupPositions(str));
    }

    /**
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public List<List<Integer>> largeGroupPositions(String str) {

        int j = 0;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                if (i - j + 1 >= 3)
                    list.add(Arrays.asList(new Integer[]{j, i}));

                j = i + 1;
            }
        }

        return list;
    }
}
