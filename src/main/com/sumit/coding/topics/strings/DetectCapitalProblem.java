package main.com.sumit.coding.topics.strings;

/*
* URL : https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
* */
public class DetectCapitalProblem {

    public static void main(String[] args) {
        System.out.println(new DetectCapitalProblem().detectCapitalUse("google"));
        System.out.println(new DetectCapitalProblem().detectCapitalUse_secondApproach("google"));
    }

    public boolean detectCapitalUse(String word) {
        int n = word.length();

        if (n == 0)
            return false;
        if (n == 1)
            return true;

        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (!Character.isUpperCase(word.charAt(i))) return false;
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }

        return true;
    }

    public boolean detectCapitalUse_secondApproach(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
