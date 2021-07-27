package main.com.sumit.coding.google.treeAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Problem URL : https://leetcode.com/problems/course-schedule/solution/
 * */
public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(numCourses, prerequisites)));
    }

    /*
     * Time Complexity: O(V+E)
     * Space Complexity: O(V+E)
     *
     * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = false;
        Map<Integer, List<Integer>> adList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // create adjacency list
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = adList.getOrDefault(src, new ArrayList<Integer>());
            list.add(dest);
            adList.put(src, list);
            indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            // reduce the indegree of each neighbour by 1
            if (adList.containsKey(node)) {
                for (Integer neighbour : adList.get(node)) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0)
                        q.add(neighbour);
                }
            }
        }

        if (i == numCourses) return topologicalOrder;

        return new int[0];
    }

}
