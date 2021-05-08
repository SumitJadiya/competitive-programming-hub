package main.com.sumit.coding.arrays;

import java.util.Arrays;

/*
  	Problem Statement :
	Design an array with values -> [1, 4, 6, 3, 8, 9, 2, 5]

	User story 1:
	Rotate the array by ‘n’ index (n can range between 0 to array length)

	User story 2:
	Sort the array (ascending/descending)

	User story 3:
	search any number “K” in the same array

	User Story 4:
	find the missing number from 1-9

* */
public class ArrayOperations {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 8, 9, 2, 5};
        int n = 3;
        int k = 6;

        new ArrayOperations().rotate(arr, n);
        System.out.println(Arrays.toString(arr)); // [9, 2, 5, 1, 4, 6, 3, 8]
        new ArrayOperations().sortArray(arr); // [1, 2, 3, 4, 5, 6, 8, 9]
        System.out.println(Arrays.toString(arr));
        System.out.println(new ArrayOperations().search(arr, k));
        System.out.println(new ArrayOperations().returnMissingNumber(arr));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void sortArray(int[] nums) {
        Arrays.sort(nums);
    }

    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    public int returnMissingNumber(int[] nums) {
        int arraySum = Arrays.stream(nums).sum();
        return 45-arraySum;
    }
}
