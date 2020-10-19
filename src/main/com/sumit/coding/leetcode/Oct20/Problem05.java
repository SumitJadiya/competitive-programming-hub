package main.com.sumit.coding.leetcode.Oct20;

/*
* URL
* https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3484/
* */
public class Problem05 {
    public static void main(String[] args) {
        System.out.println(new Problem05().bitwiseComplement(5));
    }

    public int bitwiseComplement(int N) {

        if (N==0) return 1;

        int count = 0;
        int oldNum = N;
        int num = 0;

        while(N>0){
            N>>=1;
            count++;
        }

        while(count>0){
            num = num <<1;
            num = num|1;
            count--;
        }

        return num ^ oldNum;
    }
}
