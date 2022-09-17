package main.com.sumit.coding.searching;

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

        if (x == 0 || x == 1) return x;

        int ans = -1;

        while (start <= end) {
            if (mid * mid == x) return (int) mid;
            else if (mid * mid > x) end = (int) mid - 1;
            else if (mid * mid < x) {
                ans = (int) mid;
                start = (int) mid + 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }
}
