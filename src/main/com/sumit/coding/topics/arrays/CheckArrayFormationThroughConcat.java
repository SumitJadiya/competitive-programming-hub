package main.com.sumit.coding.topics.arrays;

/*
Check Array Formation Through Concatenation

    Input: arr = [85], pieces = [[85]]
    Output: true

    Input: arr = [49,18,16], pieces = [[16,18,49]]
    Output: false
    Explanation: Even though the numbers match, we cannot reorder pieces[0].
*/

public class CheckArrayFormationThroughConcat {

    public static void main(String[] args) {
        System.out.println(new CheckArrayFormationThroughConcat().canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] p : pieces)
            if (!contains(arr, p))
                return false;
        return true;
    }

    boolean contains(int[] arr, int[] pieces) {
        int i = 0;
        int j = 0;
        while (i < arr.length && arr[i] != pieces[j]) i++;
        while (i < arr.length && j < pieces.length && arr[i] == pieces[j]) {
            i++;
            j++;
        }
        return j == pieces.length;
    }
}

