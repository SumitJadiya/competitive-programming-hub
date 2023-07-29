package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Pair Sum
 * Problem URL : https://www.codingninjas.com/codestudio/problems/pair-sum_697295?leftPanelTab=0
 *
 * Sample Input 1:
 *  5 5
 *  1 2 3 4 5
 * Sample Output 1:
 *  1 4
 *  2 3
 * */
public class PairSumProblem {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int s = 5;
        System.out.println(Arrays.deepToString(pairSum(arr, s)));
    }

    /*
     * Time Complexity : O(N^2)
     * */
    public static int[][] pairSum(int[] arr, int s) {
        // sort bcz we want answer in sorted order
        Arrays.sort(arr);

        var list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    list.add(arr[i]);
                    list.add(arr[j]);
                }
            }
        }
        int size = list.size();
        int[][] mat = new int[size / 2][2];
        int k = 0;
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat[i][j] = (int) list.get(k++);
            }
        }
        return mat;
    }
}
