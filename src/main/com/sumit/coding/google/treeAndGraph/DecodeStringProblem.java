package main.com.sumit.coding.google.treeAndGraph;

/*
 * Problem URL : https://leetcode.com/problems/decode-string/
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * */
public class DecodeStringProblem {
    int index = 0;

    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        System.out.println(new DecodeStringProblem().decodeString(str));
    }

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';

                index++;
                String decodedString = decodeString(s);
                index++;

                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }
}
