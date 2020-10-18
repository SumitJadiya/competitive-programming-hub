package main.com.sumit.coding.leetcode.Oct20;

import java.util.Arrays;

/*
* URL
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482/
* */
public class Problem03 {

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println(new Problem03().findPairs(nums, k));
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++)
            if(i==0||nums[i]!=nums[i-1])
                if(search(nums,i,k)) count++;
        return count;
    }

    private boolean search(int[] nums,int index,int k){
        int st=index+1,end=nums.length-1,val=nums[index]+k;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==val) return true;
            else if(nums[mid]>val) end=mid-1;
            else st=mid+1;
        }
        return false;
    }
}
