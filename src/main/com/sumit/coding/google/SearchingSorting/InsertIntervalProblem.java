package main.com.sumit.coding.google.SearchingSorting;

import java.util.Arrays;
import java.util.LinkedList;

/*
 *  Problem URL : https://leetcode.com/problems/insert-interval/
 *  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 *  Output: [[1,5],[6,9]]
 * */
public class InsertIntervalProblem {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {15, 18}};
        int[] newInterval = {2, 6};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));

        intervals = new int[][]{{3, 4}, {6, 18}};
        newInterval = new int[]{2, 5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     * */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[] interval;
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();

        while (idx < n && newInterval[0] > intervals[idx][0])
            output.add(intervals[idx++]);

        if (output.isEmpty() || output.getLast()[1] < newInterval[0])
            output.add(newInterval);
        else
            output.getLast()[1] = Math.max(output.getLast()[1], newInterval[1]);

        while (idx < n) {
            interval = intervals[idx++];
            if (output.getLast()[1] < interval[0])
                output.add(interval);
            else
                output.getLast()[1] = Math.max(output.getLast()[1], interval[1]);
        }

        return output.toArray(new int[output.size()][2]);
    }
}
