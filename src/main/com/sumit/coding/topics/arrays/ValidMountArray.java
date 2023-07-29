package main.com.sumit.coding.topics.arrays;

/*
* Problem URL: https://leetcode.com/problems/valid-mountain-array/
* */
public class ValidMountArray {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(new ValidMountArray().validMountainArray(arr));
    }

    public boolean validMountainArray(int[] arr) {
        int i=0;
        int len = arr.length;

        while(i+1<len && arr[i]<arr[i+1]) i++;

        if(i==0 || i==len-1) return false;

        while(i+1<len && arr[i]>arr[i+1]) i++;

        return i==len-1;
    }
}
