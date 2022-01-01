package main.com.sumit.coding.arrays;

import java.util.ArrayList;

public class FindRepeatAndMissingNumber {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);

        findRepeatedElements(list);
    }

    private static void findRepeatedElements(ArrayList<Integer> list) {

        int abs_val;
        for (int i = 0; i < list.size(); i++) {
            abs_val = Math.abs(list.get(i));

            if (list.get(abs_val - 1) > 0)
                list.set(abs_val - 1, -list.get(abs_val - 1));
            else
                System.out.println(abs_val);
        }

        System.out.println("Missing number - " + findMissingNumber(list));
    }

    private static int findMissingNumber(ArrayList<Integer> A) {
        int res = 0;
        for (int i = 1; i <= A.size(); i++) {
            if (!A.contains(i))
                res = i;
        }

        return res;
    }
}
