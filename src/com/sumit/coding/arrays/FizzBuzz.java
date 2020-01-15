package com.sumit.coding.arrays;

import java.util.ArrayList;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Resultant array = " + fizzBuzz(n));
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        System.out.println(rotateArray(A, 1));
    }

    private static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> al = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                al.add("FizzBuzz");
            else if (i % 3 == 0)
                al.add("Fizz");
            else if (i % 5 == 0)
                al.add("Buzz");
            else
                al.add(String.valueOf(i));
        }

        return al;
    }

    private static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ret.add(A.get((i + B) % A.size()));
        }
        return ret;
    }
}
