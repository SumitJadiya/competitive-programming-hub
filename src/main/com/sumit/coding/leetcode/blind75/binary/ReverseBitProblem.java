package com.sumit.coding.leetcode.blind75.binary;

/*
 * Problem URL : https://leetcode.com/problems/reverse-bits
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * */
public class ReverseBitProblem {

    public static void main(String[] args) {
        String binaryStr = "00000010100101000001111010011100";
        int binaryVal = Integer.parseUnsignedInt(binaryStr, 2);

        System.out.println(new ReverseBitProblem().reverseBits(binaryVal));
    }

    /*
     * Steps :
     * 1. Shift result to the left to make space for the next bit
     * 2. Get the least significant bit of n and add it to result
     * 3. Shift n to the right to process the next bit
     * */
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }

        return result;
    }
}
