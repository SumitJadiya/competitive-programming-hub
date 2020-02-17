package com.sumit.coding.arrays;

import java.util.ArrayList;

/**
 * Problem URL:
 * https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 */
public class TripletsWithSumBetweenGivenRange {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("2.673662");
        arr.add("2.419159");
        arr.add("0.573816");
        arr.add("2.454376");
        arr.add("0.403605");
        arr.add("2.503658");
        arr.add("0.806191");

        int result = new TripletsWithSumBetweenGivenRange().solve(arr);
        System.out.println(result);
    }

    private int solve(ArrayList<String> A) {
        //take variables a,b,c and assign it with first 3 numbers
        double a = Double.parseDouble(A.get(0));
        double b = Double.parseDouble(A.get(1));
        double c = Double.parseDouble(A.get(2));
        // excute the loop from index 3 onwards
        for (int i = 3; i < A.size(); i++) {
            // check if sum fall in (1, 2)
            if ((a + b + c) > 1 && (a + b + c) < 2) {
                return 1;
            }
            // if not, then check is sum greater then 2
            // if so, then replece MAX(a,b,c) to new number
            else if ((a + b + c) >= 2) {
                if (a > b && a > c) {
                    a = Double.parseDouble(A.get(i));
                } else if (b > c) {
                    b = Double.parseDouble(A.get(i));
                } else {
                    c = Double.parseDouble(A.get(i));
                }
            }
            // else then sum must be less than 1
            // then replece MIN(a,b,c) to new number
            else {
                if (a < b && a < c) {
                    a = Double.parseDouble(A.get(i));
                } else if (b < c) {
                    b = Double.parseDouble(A.get(i));
                } else {
                    c = Double.parseDouble(A.get(i));
                }
            }
        }
        // check for last a, b, c  pair
        if ((a + b + c) > 1 && (a + b + c) < 2) {
            return 1;
        } else {
            return 0;
        }
    }
}
