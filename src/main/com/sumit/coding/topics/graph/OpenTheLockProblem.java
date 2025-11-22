package com.sumit.coding.topics.graph;

import lombok.AllArgsConstructor;

import java.util.*;

public class OpenTheLockProblem {

    @AllArgsConstructor
    private static class PositionTracker {
        String position;
        int moves;
    }

    public static int numSteps(String target, List<String> trappedCombos) {
        if (trappedCombos.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        ArrayDeque<PositionTracker> queue = new ArrayDeque<>();
        queue.offer(new PositionTracker("0000", 0));

        HashSet<String> visited = new HashSet<>(trappedCombos);

        while (!queue.isEmpty()) {
            PositionTracker pt = queue.poll();
            if (pt.position.equals(target))
                return pt.moves;

            for (String child : getChildren(pt.position)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(new PositionTracker(child, pt.moves + 1));
                }
            }
        }

        return -1;
    }

    private static List<String> getChildren(String parent) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < parent.length(); i++) {
            int digit = parent.charAt(i) - '0';

            int up = (digit + 1) % 10;
            int down = (digit + 9) % 10;

            String left = parent.substring(0, i);
            String right = parent.substring(i + 1);

            result.add(left + up + right);
            result.add(left + down + right);
        }

        return result;
    }

    public static void main(String[] args) {
        String targetCombo = "0202";
        List<String> trappedCombos = List.of("0201", "0101", "0102", "1212", "2002");
        int res = numSteps(targetCombo, trappedCombos);
        System.out.println(res);

        System.out.println(numSteps_alternate(targetCombo, trappedCombos));
    }

    private static int numSteps_alternate(String target, List<String> trappedCombos) {
        if (trappedCombos.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        Set<String> dead = new HashSet<>(trappedCombos);
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();

                if (curr.equals(target)) return steps;
                if (dead.contains(curr)) continue;

                for (int i = 0; i < 4; i++) {
                    char ch = curr.charAt(i);
                    String left = curr.substring(0, i);
                    String right = curr.substring(i + 1);
                    String up = left+ ((ch == '9') ? '0' : (char) (ch + 1)) + right;
                    String down = left+ ((ch == '0') ? '9' : (char) (ch - 1)) + right;

                    if (!dead.contains(up) && !visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    if (!dead.contains(down) && !visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
