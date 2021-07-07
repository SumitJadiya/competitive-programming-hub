package main.com.sumit.coding.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem URL : https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
Input: rowIndex = 3
Output: [1,3,3,1]

Input: rowIndex = 3
Output: [1,3,3,1]
 */
public class PascalTriangleII {

    public static void main(String[] args) {
        int row = 3;
        System.out.println(getRow(row));
    }

    public static List<Integer> getRow(int n) {
        List<Integer> row = new ArrayList<>(Collections.singletonList(1));
        for (int k = 1; k <= n; k++)
            row.add((int) ((row.get(row.size() - 1) * (long) (n - k + 1)) / k));
        return row;
    }
}
