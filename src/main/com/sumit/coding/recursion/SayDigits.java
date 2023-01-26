package main.com.sumit.coding.recursion;

public class SayDigits {

    public static void main(String[] args) {
        int n = 420;
        String arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        System.out.println(sayDigits(n, arr));
    }

    public static String sayDigits(int n, String[] arr) {
        if (n <= 0) return "";

        int digit = n % 10;
        n /= 10;

        return sayDigits(n, arr) + arr[digit] + " ";
    }
}
