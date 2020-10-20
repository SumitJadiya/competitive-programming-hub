package main.com.sumit.coding.leetcode.Oct20;

/*
* URL:
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3500/
* */
public class Problem19 {

    public static void main(String[] args) {
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};

        System.out.println(new Problem19().minDominoRotations(A, B));
    }

    public int minDominoRotations(int[] A, int[] B) {
        int minSwaps = Math.min (numSwaps(A[0], A, B) , numSwaps(B[0], A, B));
        minSwaps = Math.min (minSwaps, numSwaps(A[0], B, A));
        minSwaps = Math.min (minSwaps, numSwaps(B[0], B, A));

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    public int numSwaps(int target, int[] A, int[] B){
        int count = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] != target && B[i] != target) return Integer.MAX_VALUE;
            else if (A[i]!=target) count++;
        }

        return count;
    }
}
