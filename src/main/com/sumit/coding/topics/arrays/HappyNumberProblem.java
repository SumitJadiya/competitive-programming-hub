package main.com.sumit.coding.topics.arrays;

/*
 *
 * Problem URL
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 *
 * */

public class HappyNumberProblem {
    public static void main(String[] args) {

        System.out.println(new HappyNumberProblem().isHappy(19));
    }

    public boolean isHappy(int n) {
        int sum = n;
        int x = n;

        if(sum==1||sum==7)
            return true;

        while(sum>9){
            sum = 0;
            while(x>0){
                int d = x%10;
                sum += d * d;
                x/=10;
            }
            if(sum==1||sum==7)
                return true;
            x = sum;
        }
        return false;
    }
}
