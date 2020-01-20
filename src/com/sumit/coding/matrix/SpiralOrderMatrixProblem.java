package com.sumit.coding.matrix;

import java.util.ArrayList;

public class SpiralOrderMatrixProblem {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        list.add(1);
        list.add(2);
//        list.add(3);
        lists.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(5);
//        list.add(6);
        lists.add(list);
        list = new ArrayList<>();
        list.add(7);
        list.add(8);
//        list.add(9);
        lists.add(list);

        list = spiralOrder(lists);
        System.out.println(list);
        System.out.println(lists);
    }

    private static ArrayList<Integer> spiralOrder(final ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> al = new ArrayList<>();
        int l = 0, n = A.get(0).size(); // column
        int k = 0, m = A.size(); // row

        while (l < n && k < m) {
            for (int i = l; i < n; i++)
                al.add(A.get(k).get(i));
            k++;
            for (int i = k; i < m; i++)
                al.add(A.get(i).get(n - 1));
            n--;
            if (k < m) {
                for (int i = n - 1; i >= l; i--)
                    al.add(A.get(m - 1).get(i));
                m--;
            }
            if (l < n) {
                for (int i = m - 1; i >= k; i--)
                    al.add(A.get(i).get(l));
                l++;
            }
        }

        return al;
    }

}
