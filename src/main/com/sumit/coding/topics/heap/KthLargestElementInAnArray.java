package com.sumit.coding.topics.heap;

import java.util.*;
import java.util.stream.Collectors;

public class KthLargestElementInAnArray {

    public static int findKthLargest(List<Integer> nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.size(), Collections.reverseOrder());
        heap.addAll(nums);

        for (int i = 1; i < k; i++)
            heap.poll();

        return heap.peek();
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }
}
