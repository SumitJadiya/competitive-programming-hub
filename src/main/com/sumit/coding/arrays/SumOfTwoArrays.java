package main.com.sumit.coding.arrays;

import java.util.Arrays;

/*
 * Sum Of Two Arrays
 * Problem URL : https://www.codingninjas.com/codestudio/problems/sum-of-two-arrays_893186
 * */
public class SumOfTwoArrays {

    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        int[] b = {9, 9, 9};

        System.out.println(Arrays.toString(findArraySum(a, a.length, b, b.length)));
    }

    /*
     * Time Complexity : O(n)
     * */
    public static int[] findArraySum(int[] a, int n, int[] b, int m) {
        int i = n - 1;
        int j = m - 1;
        int len = m;

        if (n != m) len = Math.max(m, n);
        else if (a[0] + b[0] > 9) len = m + 1;

        int[] result = new int[len];
        int k = len - 1;

        int carry = 0;

        while (i >= 0 && j >= 0) {
            int val1 = a[i--];
            int val2 = b[j--];

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            sum %= 10;
            result[k--] = sum;
        }

        while (i >= 0) {
            int sum = a[i--] + carry;
            carry = sum / 10;
            sum %= 10;
            result[k--] = sum;
        }

        while (j >= 0) {
            int sum = b[j--] + carry;
            carry = sum / 10;
            sum %= 10;
            result[k--] = sum;
        }

        if (carry != 0 && k >= 0)
            result[k--] = carry;

        return result;
    }
}
