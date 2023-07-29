package main.com.sumit.coding.companies.google.arraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Problem URL : https://leetcode.com/problems/k-closest-points-to-origin
 * */
public class KClosestPointsToOriginProblem {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {8, 1}};
        int k = 1;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<int[]> coords=new PriorityQueue<>((a,b)->((a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1])));
        PriorityQueue<int[]> coords = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        coords.addAll(Arrays.asList(points));

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++)
            ans[i] = coords.poll();

        return ans;
    }
}
