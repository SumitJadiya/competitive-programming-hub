package main.com.sumit.coding.topics.bitwise;


/*
 *  Problem URL : https://leetcode.com/problems/number-of-1-bits/
 *
 *  Input: n = 00000000000000000000000000001011
 *  Output: 3
 *  Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * */
public class NumberOfOneBits {

    public static void main(String[] args) {
        int num = 11;
        System.out.println(new NumberOfOneBits().hammingWeight(num));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }

        return count;
    }
}
