package main.com.sumit.coding.topics.arrays;

import java.util.Arrays;

/*
  	Problem Statement :
	Design an array with values -> [1, 4, 6, 3, 8, 9, 2, 5]

	User story 1:
	Rotate the array by ‘n’ index (n can range between 0 to array length)

	User story 2:
	Reverse the array

	User story 3:
	Sort the array (ascending/descending)

	User story 4:
	search any number “K” in the same array

	User Story 5:
	find the missing number from 1-9
* */
public class ArrayOperations {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 8, 9, 2, 5};
        int n = 3;
        int k = 6;

        new ArrayOperations().rotate(arr, n);
        System.out.println(Arrays.toString(arr)); // [9, 2, 5, 1, 4, 6, 3, 8]

        new ArrayOperations().reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [8, 3, 6, 4, 1, 5, 2, 9]

        new ArrayOperations().sortArray(arr); // [1, 2, 3, 4, 5, 6, 8, 9]
        System.out.println(Arrays.toString(arr));

        System.out.println(new ArrayOperations().search(arr, k)); // 5

        System.out.println(new ArrayOperations().returnMissingNumber(arr)); // 7
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
        int pivot, start = 0, end = nums.length - 1;
        while (start <= end) {
            pivot = start + (end - start) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) end = pivot - 1;
            else start = pivot + 1;
        }
        return -1;
    }

    public int returnMissingNumber(int[] nums) {
        int arraySum = Arrays.stream(nums).sum();
        return 45 - arraySum;
    }
}
