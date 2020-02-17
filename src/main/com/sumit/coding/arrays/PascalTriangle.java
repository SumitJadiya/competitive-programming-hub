package main.com.sumit.coding.arrays;

import java.util.ArrayList;

/*
 *   [1],
 *   [1,1],
 *   [1,2,1],
 *   [1,3,3,1],
 *   [1,4,6,4,1]
 *
 *   Problem URL:
 *   https://www.interviewbit.com/problems/pascal-triangle/
 *
 * */
public class PascalTriangle {

    public static void main(String[] args) {
        int n = 5;

        ArrayList<ArrayList<Integer>> lists = solve(n);

        for (ArrayList<Integer> list : lists) {
            for (int x : list) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    /**
     * @param A Input Parameter
     * @return Returns Pascal Triangle
     */
    private static ArrayList<ArrayList<Integer>> solve(int A) {
        int numRows = A;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (A == 0)
            return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {

            res.add(new ArrayList<>());
            res.get(i).add(1);

            for (int j = 0; j < i - 1; j++) {
                int num = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
                res.get(i).add(num);
            }
            res.get(i).add(1);
        }

        return res;
    }

}
