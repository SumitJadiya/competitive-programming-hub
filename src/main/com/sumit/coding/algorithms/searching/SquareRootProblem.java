package main.com.sumit.coding.algorithms.searching;

/*
 * Sqrt(x)
 * Problem URL : https://leetcode.com/problems/sqrtx/
 *
 * Input: x = 4
 * Output: 2
 * */
public class SquareRootProblem {

    public static void main(String[] args) {
        System.out.println(mySqrt(47));
        System.out.println(mySqrt(147));
    }

    /*
     * Time Complexity : O(logN)
     * */
    private static int mySqrt(int x) {
        int start = 0;
        int end = x / 2;
        long mid = start + (end - start) / 2;
        long sqr = mid * mid;

        if (x == 0 || x == 1) return x;

        while (start <= end) {
            if (sqr == x) return (int) mid;
            else if (sqr > x)
                end = (int) mid - 1;
            else if (sqr < x)
                start = (int) mid + 1;

            mid = start + (end - start) / 2;
            sqr = mid * mid;
        }

        return end;
    }
}
