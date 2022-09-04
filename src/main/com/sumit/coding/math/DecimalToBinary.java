package main.com.sumit.coding.math;

public class DecimalToBinary {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(new DecimalToBinary().decimalToBinaryConversion_positiveNumber(num));

        num = -6;
        System.out.println(new DecimalToBinary().decimalToBinaryConversion_negativeNumber(num));
    }

    private int decimalToBinaryConversion_positiveNumber(int num) {
        int ans = 0;
        int i = 0;

        while (num != 0) {
            int bit = num & 1;
            ans += bit * Math.pow(10, i++);

            num = num >> 1;
        }

        return ans;
    }

    private int decimalToBinaryConversion_negativeNumber(int num) {
        num = -1 * num;
        int ans = 0;
        int i = 0;

        while (num != 0) {
            int bit = num & 1;
            ans += bit * Math.pow(10, i++);

            num = num >> 1;
        }

        return ans;
    }

}
