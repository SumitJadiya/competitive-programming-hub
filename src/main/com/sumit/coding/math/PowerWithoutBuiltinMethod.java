package main.com.sumit.coding.math;

public class PowerWithoutBuiltinMethod {

    public static void main(String[] args) {
        double x = 29879879.00000;
        int n = -2147483648;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new PowerWithoutBuiltinMethod().myPow(x, n));
    }

    public double myPow(double x, int n) {

        // base case
        if (n == 0)
            return 1;

        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
