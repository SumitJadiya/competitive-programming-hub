package main.com.sumit.coding.google.arraysAndStrings;

import java.util.Arrays;

/*
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * */
public class MeetingRoomsIIProblem {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }

    /*
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     * */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int rooms = 0, len = intervals.length, startPtr = 0, endPtr = 0;

        Integer[] start = new Integer[len];
        Integer[] end = new Integer[len];

        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start, (a, b) -> a - b);
        Arrays.sort(end, (a, b) -> a - b);

        while (startPtr < intervals.length) {
            if (start[startPtr] >= end[endPtr]) {
                rooms--;
                endPtr++;
            }
            rooms++;
            startPtr++;
        }

        return rooms;
    }
}
