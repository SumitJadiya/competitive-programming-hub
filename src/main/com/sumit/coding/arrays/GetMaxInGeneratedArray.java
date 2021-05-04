package main.com.sumit.coding.arrays;

/*
    Get Maximum in Generated Array

    Input: n = 7
    Output: 3
    Explanation: According to the given rules:
    nums[0] = 0
    nums[1] = 1
    nums[(1 * 2) = 2] = nums[1] = 1
    nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
    nums[(2 * 2) = 4] = nums[2] = 1
    nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
    nums[(3 * 2) = 6] = nums[3] = 2
    nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
    Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.
`*/
public class GetMaxInGeneratedArray {

    public static void main(String[] args) {
        System.out.println(new GetMaxInGeneratedArray().getMaximumGenerated(7));
    }

    public int getMaximumGenerated(int n) {

        if (n == 0)
            return 0;

        int[] ans = new int[n + 1];
        ans[1] = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {
            ans[i] = (i % 2 == 0) ? ans[i / 2] : ans[i / 2] + ans[i / 2 + 1];
            if (ans[i] > max)
                max = ans[i];
        }

        return max;
    }
}
