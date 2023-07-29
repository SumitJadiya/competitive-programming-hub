package main.com.sumit.coding.topics.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * URL : https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
 */
public class TopKFrequentElementsProblem {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3};
        int k = 2;
        List<Integer> myList = new TopKFrequentElementsProblem().topKFrequent(nums, k);
        System.out.println(myList);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        for (int num : count.keySet()) {
            heap.add(num);

            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());

        Collections.reverse(top_k);
        return top_k;
    }
}
