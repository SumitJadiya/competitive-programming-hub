package main.com.sumit.coding.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * I/P A : [2, 3, 1, 5, 4]
 * I/P B : [1, 3, 5, 4, 2]
 * O/P : 10
 *
 * I/P A : [6,7,1,2,4,5,8,3]
 * I/P B : [3,7,2,5,1,8,4,6]
 * O/P : 22
 *
 * */
public class TaskSchedulingProblem {
    static int count = 0;

    public static void main(String[] args) {

        List<Integer> A = new ArrayList<>();
        A.add(8);
        A.add(6);
        A.add(4);
        A.add(3);
        A.add(5);
        A.add(1);
        A.add(2);
        A.add(7);
        A.add(9);
        A.add(10);
/*
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(5);
        A.add(4);
*/
        List<Integer> B = new ArrayList<>();
        B.add(6);
        B.add(4);
        B.add(9);
        B.add(8);
        B.add(1);
        B.add(7);
        B.add(2);
        B.add(5);
        B.add(3);
        B.add(10);
/*
        B.add(1);
        B.add(3);
        B.add(5);
        B.add(4);
        B.add(2);
*/

        System.out.println("Total Tasks - " + calculateTasks(A, B));
    }

    private static int calculateTasks(List<Integer> a, List<Integer> b) {

        int val, index;
        count = 0;
        int len = b.size();
        while (len-- > 0) {
            val = b.get(0);
            if (val != a.get(0)) {
                index = findIndex(a, val);
                a = rotateArray(a, index);
            }
            a.remove(0);
            b.remove(0);
            count += 1;
        }
        return count;
    }

    private static List<Integer> rotateArray(List<Integer> a, int index) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            tempList.add(a.remove(0));
        }

        for (int i = 0; i < index; i++) {
            a.add(tempList.get(i));
            count++;
        }

        tempList = null;
        return a;
    }

    private static int findIndex(List<Integer> a, int val) {
        int index = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != val)
                index++;
            else
                break;
        }
        return index;
    }
}
