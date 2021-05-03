package main.com.sumit.coding.strings;

/*
 Problem : https://leetcode.com/problems/determine-if-string-halves-are-alike/

    Input: s = "book"
    Output: true
    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
*/
public class HalvesAreAlikeProblem {

    public static void main(String[] args) {
        System.out.println(new HalvesAreAlikeProblem().halvesAreAlike("book"));
    }

    public boolean halvesAreAlike(String s) {

        int lvl = 0;
        int halfLen = s.length()/2;

        String vowels = "aeoiuAEOIU";

        for (int i=0; i<halfLen; i++) {

            if(vowels.indexOf(s.charAt(i)) != -1)
                lvl++;

            if(vowels.indexOf(s.charAt(i+halfLen)) != -1)
                lvl--;

        }
        return lvl==0;
    }
}
