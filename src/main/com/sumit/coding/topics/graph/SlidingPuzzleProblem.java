package com.sumit.coding.topics.graph;

import java.util.*;

public class SlidingPuzzleProblem {

    public static final String targetState = "123450";

    private static String serializeString(List<List<Integer>> nums) {
        StringBuilder result = new StringBuilder();

        for (List<Integer> num : nums)
            for (Integer integer : num)
                result.append(integer);

        return result.toString();
    }

    public static int numSteps(List<List<Integer>> initPos) {
        String input = serializeString(initPos);
        Set<String> visited = new HashSet<>();
        int level = 0;

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(input);
        visited.add(input);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();

                if (targetState.equals(temp)) return level;

                for (String node : getNeighborNodes(temp, visited)) {
                    queue.offer(node);
                }
            }
            level++;
        }

        return -1;
    }

    private static List<String> getNeighborNodes(String input, Set<String> visited) {
        List<String> result = new ArrayList<>();

        int idx = input.indexOf('0');

        int row = idx / 3;
        int col = idx % 3;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] d : dirs) {
            int newRow = d[0] + row;
            int newCol = d[1] + col;

            if (newRow < 0 || newRow >= 2 || newCol < 0 || newCol >= 3) continue;

            int newIdx = newRow * 3 + newCol;
            String finalVal = swap(input, idx, newIdx);
            if (visited.add(finalVal))
                result.add(finalVal);
        }

        return result;
    }

    private static String swap(String input, int start, int end) {
        char[] chars = input.toCharArray();
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;

        return new String(chars);
    }

    public static void main(String[] args) {
        List<List<Integer>> initPos = List.of(List.of(4, 1, 3), List.of(2, 0, 5));
        int res = numSteps(initPos);

        System.out.println(res);
    }
}
