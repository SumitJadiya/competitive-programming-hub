package main.com.sumit.coding.topics.arrays;

/*
 * integer array size = N, where N = 2M + 1
 * i/p : {2,3,4,3,4,2,7} --> M elements present twice.
 * o/p : 7
 * */
public class FindUnique {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 3, 4, 2, 7};
        System.out.println(new FindUnique().findUnique(arr));
    }

    private int findUnique(int[] arr) {
        int product = arr[0];
        for (int i = 1; i < arr.length; i++)
            product ^= arr[i]; // XOR

        return product;
    }
}
