package main.com.sumit.coding.leetcode.Oct20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/*
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3480/
*/
public class Problem01 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(2));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3

        RecentCounterAnotherApproach recentCounterAnotherApproach = new RecentCounterAnotherApproach();
        System.out.println(recentCounterAnotherApproach.ping(1));
        System.out.println(recentCounterAnotherApproach.ping(2));
        System.out.println(recentCounterAnotherApproach.ping(3001));
        System.out.println(recentCounterAnotherApproach.ping(3002));

    }
}

class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t - 3000) queue.poll();

        return queue.size();
    }
}

class RecentCounterAnotherApproach {

    TreeSet<Integer> treeSet;
    public RecentCounterAnotherApproach() {
        treeSet = new TreeSet<>();
    }

    public int ping(int t) {
        treeSet.add(t);
        return treeSet.tailSet(t-3000).size();
    }
}

