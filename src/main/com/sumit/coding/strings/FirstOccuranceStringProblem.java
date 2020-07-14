package main.com.sumit.coding.strings;

/**
 *
 *  URL : https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
 *
 *  Approach 1 : Complexity -> O((N−L)L) [Time] O(1) [Space]
 *  move sliding window along the string and compare substring in the window with the needle.
 *
 *  Approach 2 : Complexity -> O((N−L)L) ~ O(N) [Time] O(1) [Space]
 *  1. Move pn till you'll find the first character of the needle string in the haystack.
 *  2. Compute the max string match by increasing pn, pL and curr_len in the case of equal characters.
 *  3. If you managed to get the full match, curr_len == L, return the start position of that match, pn - L.
 *  4. If you didn't, backtrack: pn = pn - curr_len + 1, pL = 0, curr_len = 0.
 *
 *  Approach 3 : Complexity -> O(N) ~ O(N-L) [Time] O(1) [Space]
 *  1. Compute the hash of substring haystack.substring(0, L) and reference hash of needle.substring(0, L).
 *  2. Iterate over the start position of possible match: from 1 to N - L.
 *      i. Compute rolling hash based on the previous hash value.
 *      ii. Return start position if the hash is equal to the reference one.
 *  3. Return -1, that means that needle is not found.
 *
 */
public class FirstOccuranceStringProblem {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int index = new FirstOccuranceStringProblem().strStr_approach1(haystack, needle);
        System.out.println("Index using Approach 1 : " + index);

        index = new FirstOccuranceStringProblem().strStr_approach2(haystack, needle);
        System.out.println("Index using Approach 2 : " + index);

        index = new FirstOccuranceStringProblem().strStr_approach3(haystack, needle);
        System.out.println("Index using Approach 3 : " + index);
    }

    private int charToInt(int idx, String s){
        return (int)s.charAt(idx) - (int)'a';
    }

    private int strStr_approach3(String haystack, String needle) {
        int lengthOfNeedle = needle.length();
        int lengthOfHaystack = haystack.length();

        if(lengthOfNeedle > lengthOfHaystack) return -1;

        // base value
        int baseValue = 26;

        // Modulus value for rolling function
        long modulus = (long) Math.pow(2, 31);

        // Compute hash of haystack.substring(0, L) and needle.substring(0, L)
        long currentHash = 0;
        long referenceHash = 0;
        for (int i=0; i<lengthOfNeedle; i++){
            currentHash = (currentHash * baseValue + (new FirstOccuranceStringProblem()).charToInt(i, haystack)) % modulus;
            referenceHash = (referenceHash * baseValue + (new FirstOccuranceStringProblem()).charToInt(i, needle))%modulus;
        }

        if(currentHash == referenceHash)
            return 0;

        long al = 1;
        for (int i=1; i<=lengthOfNeedle; i++) al = (al * baseValue) % modulus;

        for (int start=1; start < (lengthOfHaystack - lengthOfNeedle + 1) ; ++start){
            // compute rolling hash in O(1)
            currentHash = (currentHash*baseValue - charToInt(start-1, haystack) *  al + charToInt(start + lengthOfNeedle - 1, haystack)) % modulus;

            if(currentHash == referenceHash)
                return start;
        }

        return -1;
    }

    private int strStr_approach2(String haystack, String needle) {

        int hLength = haystack.length();
        int nLength = needle.length();

        int start = 0 ;

        while(start<1+hLength-nLength){
            while(start<1+hLength-nLength && haystack.charAt(start) != needle.charAt(0)) ++start;

            int currentNeedleIndex = 0;
            while(start < hLength && currentNeedleIndex < nLength && haystack.charAt(start) == needle.charAt(currentNeedleIndex)) {

                ++start;
                ++currentNeedleIndex;
            }

            if(currentNeedleIndex == nLength) return start-nLength;
            start = start - currentNeedleIndex +1 ;
        }

        return -1;
    }

    private int strStr_approach1(String haystack, String needle) {

        for (int start=0; start<(1 + haystack.length() - needle.length()); start++){
            if((haystack.substring(start, start+needle.length())).equals(needle))
                return start;
        }

        return -1;
    }
}
