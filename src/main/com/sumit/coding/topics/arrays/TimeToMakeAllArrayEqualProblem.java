package main.com.sumit.coding.topics.arrays;

/*
 *
 * I/P : A = [2, 4, 1, 3, 2]
 * O/P : [4, 4, 4, 4, 4] = 8
 *
 * */
public class TimeToMakeAllArrayEqualProblem {
    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 3, 2};
        System.out.println(findTime(arr));
    }

    private static int findTime(int[] arr) {
        int count = 0, j = 0;
        int max = findMax(arr);

        for (int i = 0; i < arr.length; i++) {
            j=i;
            if (arr[j] < max) {
                count += max - arr[j];
            }
        }

        return count;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }
}
