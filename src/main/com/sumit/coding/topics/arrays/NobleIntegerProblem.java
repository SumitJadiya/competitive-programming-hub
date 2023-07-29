package main.com.sumit.coding.topics.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class NobleIntegerProblem {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-6);
        list.add(-1);
        list.add(4);

        int result = NobleIntegerProblem.solve(list);
        System.out.println("Result = " + result);
    }

    private static int solve(ArrayList<Integer> A) {
        Collections.sort(A);  //sort Array

        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) == A.size() - i - 1 && A.get(i) != A.get(i + 1))
                return 1;
        }
        if (A.get(A.size() - 1) == 0) return 1;
        return -1;
    }
}
