package main.com.sumit.coding.arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;

        System.out.println(new BinarySearch().search(nums, target));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target){

        int mid = (start+end) / 2;

        if(mid<0 || start==end) return -1;

        if(nums[mid] == target) return mid;

        if(nums[mid] > target) return binarySearch(nums, 0, mid, target);

        return binarySearch(nums, mid+1, end, target);
    }
}
