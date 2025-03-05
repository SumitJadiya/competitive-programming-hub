package com.sumit.coding.patterns.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersectionsProblem {

    public static void main(String[] args) {
        int[][][] inputIntervalLista = {
                {{1, 4}, {5, 6}, {7, 8}, {9, 15}},
                {{1, 4}, {5, 6}, {9, 15}},
                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        List<int[]> intersectionList = new ArrayList<>();

        int i = 0, j = 0;
        int n = intervalLista.length, m = intervalListb.length;

        int[] curr = new int[2];

        while (i < n && j < m) {
            curr[0] = Math.max(intervalLista[i][0], intervalListb[j][0]);
            curr[1] = Math.min(intervalLista[i][1], intervalListb[j][1]);

            if (curr[0] <= curr[1])
                intersectionList.add(curr);

            if (intervalLista[i][1] < intervalListb[j][1])
                i++;
            else
                j++;

            curr = new int[2];
        }

        return intersectionList.toArray(new int[intersectionList.size()][]);
    }
}
