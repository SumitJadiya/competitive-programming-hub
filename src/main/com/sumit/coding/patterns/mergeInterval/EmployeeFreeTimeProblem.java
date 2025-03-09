package com.sumit.coding.patterns.mergeInterval;

import lombok.Setter;

import java.util.*;
import java.util.stream.IntStream;

public class EmployeeFreeTimeProblem {

    public static class Interval {
        int start;
        int end;
        @Setter
        boolean closed;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.closed = true;
        }
    }

    public static void main(String[] args) {
        List<List<List<Interval>>> inputs1 = List.of(
                List.of(
                        List.of(new Interval(1, 2), new Interval(5, 6)),
                        List.of(new Interval(1, 3)),
                        List.of(new Interval(4, 10))
                ),
                List.of(
                        List.of(new Interval(1, 3), new Interval(6, 7)),
                        List.of(new Interval(2, 4)),
                        List.of(new Interval(2, 5), new Interval(9, 12))
                ),
                List.of(
                        List.of(new Interval(2, 3), new Interval(7, 9)),
                        List.of(new Interval(1, 4), new Interval(6, 7))
                ),
                List.of(
                        List.of(new Interval(3, 5), new Interval(8, 10)),
                        List.of(new Interval(4, 6), new Interval(9, 12)),
                        List.of(new Interval(5, 6), new Interval(8, 10))
                ),
                List.of(
                        List.of(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11)),
                        List.of(new Interval(3, 4), new Interval(7, 12)),
                        List.of(new Interval(1, 3), new Interval(7, 10)),
                        List.of(new Interval(1, 4)),
                        List.of(new Interval(7, 10), new Interval(11, 12))
                ),
                List.of(
                        List.of(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8)),
                        List.of(new Interval(2, 3), new Interval(4, 5), new Interval(6, 8))
                ),
                List.of(
                        List.of(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        List.of(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        List.of(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        List.of(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12))
                )
        );

        int i = 1;
        List<List<List<Interval>>> inputs = new ArrayList<>();

        for (int j = 0; j < inputs1.size(); j++) {
            inputs.add(new ArrayList<List<Interval>>());

            for (int k = 0; k < inputs1.get(j).size(); k++) {
                inputs.get(j).add(new ArrayList<Interval>());

                for (int g = 0; g < inputs1.get(j).get(k).size(); g++) {
                    inputs.get(j).get(k).add(inputs1.get(j).get(k).get(g));
                }
            }
        }

        for (int j = 0; j < inputs.size(); j++) {
            System.out.println(i + ".\tEmployee Schedules:\n");

            for (int s = 0; s < inputs.get(j).size(); s++) {
                System.out.println("\t\t" + display(inputs.get(j).get(s)));
            }

            System.out.println("\n\tEmployees' free time " + display(employeeFreeTime(inputs.get(j))));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i += 1;
        }
    }

    public static String display(List<Interval> l1) {
        if (l1.isEmpty()) {
            return "[]";
        }

        StringBuilder resultStr = new StringBuilder("[");

        for (int i = 0; i < l1.size() - 1; i++) {
            resultStr.append("[").append(l1.get(i).start).append(", ");
            resultStr.append(l1.get(i).end).append("], ");
        }

        resultStr.append("[").append(l1.get(l1.size() - 1).start).append(", ");
        resultStr.append(l1.get(l1.size() - 1).end).append("]");
        resultStr.append("]");

        return resultStr.toString();
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> employeeSchedule = schedule.get(i);
            Interval interval = employeeSchedule.get(0);
            heap.offer(new int[]{interval.start, i, 0});
        }

        List<Interval> result = new ArrayList<>();

        assert heap.peek() != null;
        int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).start;

        while (!heap.isEmpty()) {
            int[] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];

            Interval interval = schedule.get(i).get(j);

            if (interval.start > previous)
                result.add(new Interval(previous, interval.start));

            previous = Math.max(previous, interval.end);

            if (j + 1 < schedule.get(i).size()) {
                Interval nextInterval = schedule.get(i).get(j + 1);
                heap.offer(new int[]{nextInterval.start, i, j + 1});
            }
        }
        return result;
    }
}
