package main.com.sumit.coding.topics.math;

/*
 * Problem URL : https://leetcode.com/problems/reverse-integer/
 *
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Input: x = 123
 * Output: 321
 * */
public class ReverseInteger {
    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(new ReverseInteger().reverse(x));

        x = 214748;
        System.out.println(new ReverseInteger().reverse(x));

    }

    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int rem = x % 10;

            if (answer > Integer.MAX_VALUE / 10 || answer < Integer.MIN_VALUE / 10)
                return 0;

            answer = answer * 10 + rem;
            x = x / 10;
        }

        return answer;
    }
}
