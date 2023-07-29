package main.com.sumit.coding.topics.math;

/**
 * URL : https://leetcode.com/articles/add-digits/
 */
public class AddDigitsProblem {

    public static void main(String[] args) {
        int num = 38;
        System.out.println(new AddDigitsProblem().addDigits(num));
    }

    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
