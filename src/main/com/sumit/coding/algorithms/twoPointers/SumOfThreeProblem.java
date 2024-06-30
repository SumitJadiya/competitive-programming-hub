package main.com.sumit.coding.algorithms.twoPointers;

import java.util.Arrays;

/*
 * Given an array of integers, nums, and an integer value, target, determine if there are any three integers in nums whose sum is equal to the target, that is, nums[i] + nums[j] + nums[k] == target. Return TRUE if three such integers exist in the array. Otherwise, return FALSE.
 *
 * Note: A valid triplet consists of elements with distinct indexes.
 * */
public class SumOfThreeProblem {

    public static void main(String[] args) {
        int[] arr = {304, 449, 472, -906, -173, 459, 830, -241, 355, -945, 964, -78, 283, 511, -582, 711, -961, 892, -465, 388, -767, 774, 398, -406, -471, -905, -869, -658, -445, -86, 636, -348, -864, -309, -953, 646, -599, 66, 352, 417, 454, -454, 784, -876, -654, -450, -428, -939, -8, -288, 956, -818, -217, 698, -535, -729, 875, -299, -388, 600, 975, 63, 119, -150, 182, -181, 380, -390, 130, -99, 589, -912, -38, -610, -613, 517, -420, 311, 696, 702, 54, 713, 904, -972, -447, 230, 749, 41, 251, 163, -78, -616, -85, 173, -301, -126, -640, -371, -821, -525, -524, -150, 691, 505, -814, -349, -135, -607, -258, -239, -20, 845, -741, 890, -512, 616, 536, 903, -691, 771, -574};
        System.out.println(arr.length);
        int target = 0;

        System.out.println(findSumOfThree(arr, target));
    }

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);

        for (int idx = 0; idx < nums.length - 2; idx++) {
            int low = idx + 1, high = nums.length - 1;

            while (low < high) {
                int sum = nums[idx] + nums[low] + nums[high];
                if (sum == target)
                    return true;
                else if (nums[idx] < sum)
                    low++;
                else
                    high--;
            }
        }
        return false;
    }
}
