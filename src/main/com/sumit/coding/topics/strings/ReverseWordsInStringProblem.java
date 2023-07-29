package main.com.sumit.coding.topics.strings;

public class ReverseWordsInStringProblem {

    public static void main(String[] args) {

        String s1 = "";
        String result = ReverseWordsInStringProblem.reverseWords_approach1(s1);
        System.out.println("Reversed - " + result);

//         System.out.println("Reversed - " + ReverseWordsInStringProblem.reverseWords_approach2(s1));
    }

    private static String reverseWords_approach1(String s1) {

        String result = "";
        String[] substrings = s1.trim().split("\\s+");
        if(substrings.length == 0)
            return "";

        for (int i = substrings.length - 1; i >= 0; i--)
            result += substrings[i] + " " ;

        return result.substring(0, result.length() - 1);
    }
}
