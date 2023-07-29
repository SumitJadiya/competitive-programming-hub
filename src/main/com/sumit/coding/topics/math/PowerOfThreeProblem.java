package main.com.sumit.coding.topics.math;

public class PowerOfThreeProblem {

    public static boolean isPowerOfTwo_UsingMath(int n) {
        var val = 1162261467; // 3^19 i.e. biggest power of 3

        return n > 0 && val % n == 0;
    }

    public static void main(String[] args) {
        var num = 59049;
        System.out.println(isPowerOfTwo_UsingMath(num));
    }
}
