package main.com.sumit.coding.dp;

public class MaximumProductSubarrayProblem {

    public static void main(String[] args) {
        int[] nums = {2, -5, 3, 1, -4, 0, -10, 2, 8};

        System.out.println(new MaximumProductSubarrayProblem().maxProduct_firstApproach(nums));
        System.out.println(new MaximumProductSubarrayProblem().maxProduct_secondApproach(nums));

        nums = new int[]{0, 2, 3, -2, 4, 8};
        System.out.println(new MaximumProductSubarrayProblem().maxProduct_firstApproach(nums));
        System.out.println(new MaximumProductSubarrayProblem().maxProduct_secondApproach(nums));

    }

    /*
     * Time complexity - O(N)
     * */
    public int maxProduct_firstApproach(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        int curr, tempMax;

        for (int i = 1; i < nums.length; i++) {
            curr = nums[i];
            tempMax = Math.max(curr, Math.max(curr * minSoFar, curr * maxSoFar));
            minSoFar = Math.min(curr, Math.min(curr * minSoFar, curr * maxSoFar));
            maxSoFar = tempMax;

            if (result < maxSoFar) result = maxSoFar;
        }

        return result;
    }

    /*
     * Time complexity - O(N)
     * */
    public int maxProduct_secondApproach(int[] nums) {
        int max = Integer.MIN_VALUE;

        int product = 1;
        for (int num : nums) {
            product *= num;
            max = Math.max(product, max);
            if (product == 0) product = 1;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(product, max);
            if (product == 0) product = 1;
        }

        return max;
    }
}
