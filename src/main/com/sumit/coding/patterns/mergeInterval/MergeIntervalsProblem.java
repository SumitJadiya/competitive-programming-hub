package com.sumit.coding.patterns.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsProblem {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) {
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0])
                merged.add(interval);
            else
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1] , interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}