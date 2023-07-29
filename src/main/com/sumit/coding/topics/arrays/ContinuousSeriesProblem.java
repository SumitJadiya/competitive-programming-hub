package main.com.sumit.coding.topics.arrays;

public class ContinuousSeriesProblem {

    public static void main(String[] args) {

        // int[] arr = {5, 7, 9, 10, 11, 13, 14};
        int[] arr = {1, 0, 2, 9, 3, 8, 6};

        int result = ContinuousSeriesProblem.checkContinuousSeries(arr);
        System.out.println("Count - " + result);
    }

    private static int checkContinuousSeries(int[] arr) {

        int count = 0;
        int max = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1) {
                max++;
            }

            if (max > 0) {
                count++;
                while (i < arr.length - 1 && arr[i] == arr[i + 1] - 1)
                    i++;
                max = 0;
            }

        }
        return count;
    }
}
