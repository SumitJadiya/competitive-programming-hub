package main.com.sumit.coding.topics.recursion;

public class CheckIfArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 9, 11, 14};
        int len = arr.length;

        String result = isSorted(arr, 0, len) ? "Sorted" : "Not Sorted";
        System.out.println("This array is " + result);
    }

    private static boolean isSorted(int[] arr, int idx, int len) {

        if (len == 0 || len == 1 || len == idx) return true;

        if (idx + 1 < len && arr[idx] > arr[idx + 1]) {
            return false;
        } else {
            return isSorted(arr, ++idx, len);
        }
    }
}
