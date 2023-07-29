package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(-1);
        list.add(1);

        System.out.println("First Missing Positive number is - " + firstMissingPositive(list));
    }

    private static int firstMissingPositive(ArrayList<Integer> A) {
        if (A.size() == 0) return 1;
        int lastSwapped = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 0 && A.get(i) != i + 1 && A.get(i) < A.size() && A.get(i) != lastSwapped) {
                lastSwapped = A.get(i);
                Collections.swap(A, i, A.get(i) - 1);
                --i;
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) return i + 1;
        }

        return A.size() + 1;
    }
}
