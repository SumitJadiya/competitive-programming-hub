package com.sumit.coding.topics.heap;

import java.util.Arrays;
import java.util.List;

public class KthSmallestElementInASortedMatrixProblem {



    public static int kthSmallest(List<List<Integer>> matrix, int k) {

        return 0;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(List.of(1, 5, 9), List.of(10, 11, 13), List.of(12, 13, 15));
        int k = 8;
        int res = kthSmallest(matrix, k);
        System.out.println(res);
    }
}
