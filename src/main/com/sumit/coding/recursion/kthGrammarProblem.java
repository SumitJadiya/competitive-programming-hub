package main.com.sumit.coding.recursion;

/*
    Problem URL : https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
    Input: n = 2, k = 1  Output: 0
    Explanation: row 1: 0  row 2: 01
*/
public class kthGrammarProblem {

    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2,2));
        System.out.println(kthGrammar(3,2));
    }

    public static int kthGrammar(int n, int k) {
        if(n==1) return 0;

        if (k%2 == 0) {
            if(kthGrammar(n-1, k/2) == 0) return 1;
            else return 0;
        } else {
            if(kthGrammar(n-1, (k+1)/2) == 0) return 0;
            else return 1;
        }
    }
}
