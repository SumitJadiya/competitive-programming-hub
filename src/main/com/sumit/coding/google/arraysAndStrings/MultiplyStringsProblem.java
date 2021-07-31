package main.com.sumit.coding.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/multiply-strings
 * Input : "498828660196", "840477629533"
 * Expected : "419254329864656431168468"
 *
 * */
public class MultiplyStringsProblem {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        System.out.println(multiply(num1, num2));
    }

    /*
     * Time Complexity : O(n*m)
     * Space Complexity : O(n+m)
     * */
    public static String multiply(String num1, String num2) {

        //1. Taking care of Boundary Case
        if (num1.equals("0") || num2.equals("0")) return "0";

        //2.at max length of product will be n+m
        int[] ans = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int valueIdx = i + j + 1;
                int remainderIdx = i + j;
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                //3.Adding value of remainder if present earlier at valueidx
                product += ans[valueIdx];

                //4.digit value
                ans[valueIdx] = product % 10;

                //5.Remainder from me
                ans[remainderIdx] += product / 10;
            }
        }

        boolean precedingZeros = true;
        StringBuilder result = new StringBuilder("");

        //6.As we have made a array of maximum length n*m=n+m So result will be less than or equal to this. in less than case inital values will be zeros . So have to Remove Preceding Zeroes.
        for (int i = 0; i < ans.length; i++) {
            int value = ans[i];
            if (value != 0) precedingZeros = false;
            if (!precedingZeros) result.append(value);
        }

        return result.toString();
    }
}
