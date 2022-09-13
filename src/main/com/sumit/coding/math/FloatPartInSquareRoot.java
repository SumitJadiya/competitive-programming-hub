package main.com.sumit.coding.math;

public class FloatPartInSquareRoot {

    public static void main(String[] args) {
        int n = 37;
        int temp = mySqrtIntegerPart(n);
        System.out.println(morePrecision(n, 3, temp));
        System.out.println(morePrecision(n, 4, temp));
    }

    /*
     * Time Complexity : O(logN)
     * */
    private static int mySqrtIntegerPart(int x) {
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

    private static double morePrecision(int n, int precision, int temp) {
        double factor = 1;
        double ans = temp;

        for (int i = 0; i < precision; i++) {
            factor /= 10;
            for (double j = ans; j * j < n; j += factor) {
                ans = j;
            }
        }

        return ans;
    }
}
