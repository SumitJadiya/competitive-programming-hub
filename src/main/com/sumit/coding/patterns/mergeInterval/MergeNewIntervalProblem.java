package com.sumit.coding.patterns.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeNewIntervalProblem {

    public static void main(String[] args) {

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int index = 0;
        int end = existingIntervals.length;

        List<int[]> merged = new ArrayList<>();

        while (index < end && existingIntervals[index][1] < newInterval[0]) {
            merged.add(existingIntervals[index]);
            index++;
        }

        while (index < end && existingIntervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(existingIntervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(existingIntervals[index][1], newInterval[1]);
            index++;
        }

        merged.add(newInterval);

        while (index < end) {
            merged.add(existingIntervals[index]);
            index++;
        }

        return merged.toArray(new int[merged.size()][]);
    }
}