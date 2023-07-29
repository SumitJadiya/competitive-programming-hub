package main.com.sumit.coding.topics.java8.interviewQuestions;

import java.util.HashMap;
import java.util.List;

public class PrintFrequency {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 3, 4, 3, 2, 3, 3, 3, 3, 3);
        var map = new HashMap<Integer, Integer>();

        for (int i : list)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int max = 0;
        for (int i : map.keySet())
            if (max < map.get(i)) max = map.get(i);

        System.out.println(max);
    }
}
