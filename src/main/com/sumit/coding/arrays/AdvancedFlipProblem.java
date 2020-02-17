package main.com.sumit.coding.arrays;

/**
 * Problem URL:
 * https://www.interviewbit.com/problems/flip/
 */
public class AdvancedFlipProblem {
    public static void main(String[] args) {

        AdvancedFlipProblem advancedFlipProblem = new AdvancedFlipProblem();
        String str = "010111";

        int[] res = advancedFlipProblem.flip(str);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    /**
     * @param A Input String
     * @return Output Array
     */
    public int[] flip(String A) {
        if (!A.contains("0")) {
            return new int[]{};
        }

        int maxDiff = 0, diff = 0;
        int start = 0;
        int res[] = new int[2];

        for (int i = 0; i < A.length(); i++) {
            diff += A.charAt(i) == '0' ? 1 : -1;

            if (diff < 0) {
                diff = 0;
                start = i + 1;
                continue;
            }

            if (diff > maxDiff) {
                maxDiff = diff;
                res[0] = start + 1;
                res[1] = i + 1;
            }
        }

        return res;
    }
}
