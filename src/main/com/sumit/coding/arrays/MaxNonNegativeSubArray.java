package main.com.sumit.coding.arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();
        ArrayList<Integer> al = new ArrayList<>();
/*
        al.add(1);
        al.add(2);
        al.add(5);
        al.add(-7);
        al.add(2);
        al.add(3);
*/
/*        al.add(336465782);
        al.add(-278722862);
        al.add(-2145174067);
        al.add(1101513929);
        al.add(1315634022);
        al.add(-1369133069);
        al.add(1059961393);
        al.add(628175011);
        al.add(-1131176229);
        al.add(-859484421);
 */
        al.add(1967513926);
        al.add(1540383426);
        al.add(-1303455736);
        al.add(-521595368);
        al = maxNonNegativeSubArray.maxset(al);
        al.forEach(System.out::println);
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        long max = Integer.MIN_VALUE;
        long sum = 0;
        int len = A.size();
        for (int i = 0; i < len; i++) {
            if (A.get(i) < 0) {
                if (max < sum) {
                    result = new ArrayList<>();
                    max = sum;
                    copyList(temp, result);

                }
                sum = 0;
                temp = new ArrayList<>();
            } else {
                temp.add(A.get(i));
                sum += A.get(i);
            }
            if(i==len-1){
                if (max < sum) {
                    result = new ArrayList<>();
                    max = sum;
                    copyList(temp, result);
                }
            }
        }
        return result;
    }

    private void copyList(ArrayList<Integer> temp, ArrayList<Integer> result) {
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i));
        }
    }

}
