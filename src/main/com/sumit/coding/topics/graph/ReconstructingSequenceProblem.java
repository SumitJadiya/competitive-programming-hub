package com.sumit.coding.topics.graph;

import java.util.*;

public class ReconstructingSequenceProblem {

    public static boolean sequenceReconstruction(List<Integer> originals, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int original : originals)
            graph.put(original, new ArrayList<>());

        for (List<Integer> seq : seqs)
            graph.get(seq.get(0)).add(seq.get(1));

        topoSort(graph);
        return false;
    }


    private static List<Integer> topoSort(Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> inDegree = findInDegree(graph);

        inDegree.forEach((key, value) -> {
            if (value == 0)
                queue.add(key);
        });

        return null;
    }

    private static Map<Integer, Integer> findInDegree(Map<Integer, List<Integer>> graph) {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> original = List.of(1, 2, 3);
        List<List<Integer>> seqs = List.of(List.of(1, 2), List.of(1, 3), List.of(2, 3));

        boolean res = sequenceReconstruction(original, seqs);
        System.out.println(res);
    }
}
