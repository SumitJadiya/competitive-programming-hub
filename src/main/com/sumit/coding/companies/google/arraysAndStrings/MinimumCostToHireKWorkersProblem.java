package main.com.sumit.coding.companies.google.arraysAndStrings;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem URL : https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 * */
public class MinimumCostToHireKWorkersProblem {

    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;

        System.out.println(new MinimumCostToHireKWorkersProblem().mincostToHireWorkers(quality, wage, k));
    }

    /*
     * Time Complexity : O(N logN)
     * Space Complexity : O(N)
     * N is number of workers
     * */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = Integer.MAX_VALUE;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();

        for (Worker worker : workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;

            if (pool.size() > k) sumq += pool.poll();
            if (pool.size() == k) ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker worker) {
        return Double.compare(ratio(), worker.ratio());
    }
}

