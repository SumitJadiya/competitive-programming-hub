package main.com.sumit.coding.topics.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PermutationsProblem {
    int n;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new PermutationsProblem().permute(nums));
    }

    public void backtrack(ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n)
            output.add(new ArrayList<>(nums));

        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums)
            nums_lst.add(num);

        this.n = nums.length;
        backtrack(nums_lst, output, 0);
        return output;
    }
}
