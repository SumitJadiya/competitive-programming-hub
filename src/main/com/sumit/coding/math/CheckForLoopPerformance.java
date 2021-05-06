package main.com.sumit.coding.math;

public class CheckForLoopPerformance {

    public static void main(String[] args) {

        System.out.println(new CheckForLoopPerformance().singleForLoop()); // 805557
        System.out.println(new CheckForLoopPerformance().twoForLoops()); // 1152050
        System.out.println(new CheckForLoopPerformance().threeForLoops()); // 1352467
        System.out.println(new CheckForLoopPerformance().twoInnerLoops()); // 2165783
    }

    public long singleForLoop() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) { /*do nothing */ }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }

    public long twoForLoops() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) { /* do nothing */ }
        for (int i = 0; i < 100000; i++) { /* do nothing */ }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }

    public long threeForLoops() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) { /* do nothing */ }
        for (int i = 0; i < 100000; i++) { /* do nothing */ }
        for (int i = 0; i < 100000; i++) { /* do nothing */ }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }

    public long twoInnerLoops() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) { /* do nothing */ }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }
}
