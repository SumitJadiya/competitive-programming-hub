package main.com.sumit.coding.google.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * Return the smallest sorted list of ranges that cover every missing number exactly.
 * That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 *
 * Each range [a,b] in the list should be output as: "a->b" if a != b  and  "a" if a == b
 *
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are: [2,2] --> "2", [4,49] --> "4->49", [51,74] --> "51->74", [76,99] --> "76->99"
 * */
public class MissingRangesProblem {

    public static void main(String[] args) {

        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(new MissingRangesProblem().findMissingRanges(nums, lower, upper));
    }

    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;

        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= curr - 1)
                result.add(formatRange(prev + 1, curr - 1));
            prev = curr;
        }
        return result;
    }

    private String formatRange(int lower, int upper) {
        if (lower == upper) return String.valueOf(lower);
        return lower + "->" + upper;
    }
}
