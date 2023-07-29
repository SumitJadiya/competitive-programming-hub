package main.com.sumit.coding.companies.google.arraysAndStrings;

/*
 * Problem URL : https://leetcode.com/problems/maximize-distance-to-closest-person/
 *
 * Input: seats = [1,0,0,0,1,0,1]  Output: 2
 *
 * Explanation: If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1. Thus, the maximum distance to the closest person is 2.
 * */
public class MaximizeDistanceToClosestPersonProblem {

    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0, 1, 0, 1};

        System.out.println(new MaximizeDistanceToClosestPersonProblem().maxDistToClosest_approach1(seats));
        System.out.println(new MaximizeDistanceToClosestPersonProblem().maxDistToClosest_approach2(seats));
        System.out.println(new MaximizeDistanceToClosestPersonProblem().maxDistToClosest_approach3(seats));
    }

    /*
     * Algorithm:
     * 1. For Group of K adjacent empty seats b/w two ppls, the ans is (K+1)/2
     * 2. For group of empty seats b/w the edges of the row and one other person, ans is K
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
    public int maxDistToClosest_approach3(int[] seats) {

        int k = 0;
        int ans = 0;
        int len = seats.length;

        for (int seat : seats) {
            if (seat == 1) k = 0;
            else {
                ++k;
                ans = Math.max(ans, (k + 1) / 2);
            }
        }

        // left edges
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                ans = Math.max(ans, i);
                break;
            }
        }

        // right edges
        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                ans = Math.max(ans, len - 1 - i);
                break;
            }
        }

        return ans;
    }

    /*
     * Algorithm:
     * prev = the filled seat at or to the left of i
     * future = the filled seat at or to the right of i
     * closest person is at min(i-prev, future-i)
     * Exception : i-prev = infinity if there's no person to the left (same for right)
     *
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
    public int maxDistToClosest_approach2(int[] seats) {
        int ans = 0;
        int len = seats.length;

        int prev = -1, future = 0;

        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) prev = i;
            else {
                while (future < len && seats[future] == 0 || future < i) future++;

                int left = prev == -1 ? len : i - prev;
                int right = future == len ? len : future - i;

                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }

    /*
     * Algorithm:
     * Construct left[i] and right[i] such that left[i] = left[i-1] + 1 if seat is empty and 0 if seat is full. (same for right[i])
     *
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     * */
    public int maxDistToClosest_approach1(int[] seats) {
        int ans = 0;
        int len = seats.length;

        int[] right = new int[len];
        int[] left = new int[len];
        right[len - 1] = left[0] = len;

        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i - 1] + 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < len - 1) right[i] = right[i + 1] + 1;
        }

        for (int i = 0; i < len; i++)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(right[i], left[i]));

        return ans;
    }
}
