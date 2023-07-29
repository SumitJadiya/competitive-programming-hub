package main.com.sumit.coding.topics.hashing;
import java.util.HashMap;
import java.util.Map;

/*
Problem
URL : https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1

Count the triplets -
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

Example 2:

Input:
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits
*/
public class CountTripletsInArray {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2};
        System.out.println(countTriplet(arr, arr.length));
    }

    static int countTriplet(int arr[], int n) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(arr[i], 1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.getOrDefault((arr[i] + arr[j]), 0) > 0)
                    count++;
            }
        }
        return count;
    }
}
