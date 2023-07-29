package main.com.sumit.coding.topics.math;

/**
 *  URL : https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/
 */
public class CheckPowerOf4Problem {

    public static void main(String[] args) {
        System.out.println(new CheckPowerOf4Problem().isPowerOfFour(256));
        System.out.println(new CheckPowerOf4Problem().isPowerOfFour(36));
    }

    public boolean isPowerOfFour(int num) {
        double loggedValue = Math.log(num) / Math.log(4);
        return (num > 0) && (loggedValue == Math.floor(loggedValue));
    }
}
