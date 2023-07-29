package main.com.sumit.coding.topics.arrays;

/*
 *
 *  Input : A = {1, 3, -1}
 *  Output : 5
 *  f(1, 1) = f(2, 2) = f(3, 3) = 0
 *  f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 *  f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 *  f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *  So, we return 5.
 *
 *  Problem URL:
 *  https://www.interviewbit.com/problems/maximum-absolute-difference/
 *
 * */

import java.util.ArrayList;

public class MaxAbsoluteDifferenceProblem {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(-1);

        System.out.println("Max Absolute Sum -> " + maxAbsoluteDifference(list));
    }

    private static int maxAbsoluteDifference(ArrayList<Integer> A) {

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }
}
