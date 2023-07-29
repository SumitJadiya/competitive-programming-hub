package main.com.sumit.coding.topics.math;

public class BinaryToDecimal {

    public static void main(String[] args) {
        String num = "10101";
        System.out.println(new BinaryToDecimal().convertBinaryToDecimal(num));
    }

    private int convertBinaryToDecimal(String num) {
        int index = num.length() - 1;
        int answer = 0;

        for (char ch : num.toCharArray())
            answer += Math.pow(2, index--) * (ch - '0');

        return answer;
    }

}
