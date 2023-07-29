package main.com.sumit.coding.topics.strings;

import java.math.BigInteger;

/**
 * Problem URL : https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
 *
 * Algorithm :
 * Step 1 - Convert a and b into integers x and y.
 *      x will be used to keep the answer
 *      y will be used to keep the carry
 *
 * Step 2 - While carry is non zero [y!=0]
 * -> current answer without carry is XOR of X & Y ->> answer = X XOR Y
 * -> current carry is left shifted AND of X & Y ->> carry = (X AND Y) << 1
 * -> for next loop,
 *      x = answer
 *      y = carry
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;

        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
