package main.com.sumit.coding.google.treeAndGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleI {

    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        System.out.println(new CourseScheduleI().canFinish(numCourses, prerequisites));
    }

    /*
     * Time Complexity : O(E + V) -> V = number of vertex and E = number of dependencies
     * Space Complexity : O(E + V) -> V = number of vertex and E = number of dependencies
     * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step 1: check for no cycle
        if (prerequisites.length == 0) return true;

        // step 2: create map of course -> list of next courses
        HashMap<Integer, GNode> graph = new HashMap<>();

        // step 3: build the graph
        for (int[] relation : prerequisites) {
            GNode prevNode = getCreateGNode(graph, relation[1]);
            GNode nextNode = getCreateGNode(graph, relation[0]);

            prevNode.outNodes.add(relation[0]);
            nextNode.inDegrees += 1;
        }

        // step 4: Start with the course with no prerequisite
        int totalDep = prerequisites.length;
        LinkedList<Integer> nodepCourses = new LinkedList<>();
        for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
            GNode gNode = entry.getValue();
            if (gNode.inDegrees == 0)
                nodepCourses.add(entry.getKey());
        }

        int removedEdges = 0;
        while (nodepCourses.size() > 0) {
            Integer course = nodepCourses.pop();

            for (Integer nextCourse : graph.get(course).outNodes) {
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees -= 1;
                removedEdges += 1;

                if (childNode.inDegrees == 0)
                    nodepCourses.add(nextCourse);
            }
        }

        return removedEdges == totalDep;
    }

    protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
        GNode gnode = null;
        if (graph.containsKey(course)) {
            gnode = graph.get(course);
        } else {
            gnode = new GNode();
            graph.put(course, gnode);
        }
        return gnode;
    }
}

class GNode {
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}
