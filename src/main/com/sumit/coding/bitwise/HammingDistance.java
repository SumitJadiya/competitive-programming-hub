package main.com.sumit.coding.bitwise;

/*
 * URL - https://leetcode.com/problems/hamming-distance/description/
 * */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;

        System.out.println(new HammingDistance().hammingDistance(x, y));
    }
}
