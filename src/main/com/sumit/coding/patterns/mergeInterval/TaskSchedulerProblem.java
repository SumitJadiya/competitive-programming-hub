package com.sumit.coding.patterns.mergeInterval;

public class TaskSchedulerProblem {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C', 'C'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int maxFrequency = 0;
        int[] taskFrequency = new int[26];

        for (char task : tasks)
            taskFrequency[task - 'A']++;

        for (int count : taskFrequency)
            maxFrequency = Math.max(maxFrequency, count);

        int countOfMaxFrequency = 0;

        for (int count : taskFrequency)
            if (count == maxFrequency)
                countOfMaxFrequency++;

        int minInterval = (maxFrequency - 1) * (n+1) + countOfMaxFrequency;

        return Math.max(minInterval, tasks.length);
    }
}