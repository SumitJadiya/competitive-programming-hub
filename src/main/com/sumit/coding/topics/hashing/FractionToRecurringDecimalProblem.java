package main.com.sumit.coding.topics.hashing;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimalProblem {

    public static void main(String[] args) {

        int numerator = 2, denominator = 4;
        System.out.println("(" + numerator + "/" + denominator + ") : " + fractionToDecimal(numerator, denominator));

        numerator = -5;
        denominator = 333;
        System.out.println("(" + numerator + "/" + denominator + ") : " + fractionToDecimal(numerator, denominator));

        numerator = 20;
        denominator = 14;
        System.out.println("(" + numerator + "/" + denominator + ") : " + fractionToDecimal(numerator, denominator));

        numerator = 200;
        denominator = 4;
        System.out.println("(" + numerator + "/" + denominator + ") : " + fractionToDecimal(numerator, denominator));

        numerator = 47;
        denominator = 18;
        System.out.println("(" + numerator + "/" + denominator + ") : " + fractionToDecimal(numerator, denominator));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return String.valueOf(numerator);
        if (denominator == 0) return "ERROR";

        StringBuilder result = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();

        if (numerator < 0 ^ denominator < 0)
            result.append("-");

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        result.append(numerator / denominator);

        long remainder = numerator % denominator;
        if (remainder == 0) return result.toString();

        result.append(".");

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());
            result.append(remainder / denominator);
            remainder = (remainder % denominator) * 10;

            System.out.println("remainder (" + numerator + "/" + denominator + ") : " + remainder);
        }

        return result.toString();
    }
}
