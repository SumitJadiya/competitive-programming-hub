package main.com.sumit.coding.strings;

public class BinaryStringProblem {

    public static void main(String[] args) {

        final String txt = "101011";

        int count = BinaryStringProblem.binarySubString(txt);
        System.out.println("Number of binary substrings = " + count);
    }

    private static int binarySubString(String txt) {

        int n = txt.length();
        int count = 0;
        int j = 0, i;

        for (i = 0; i < n; i++) {
            if (txt.charAt(i) == '1')
                j++;
        }

        for (i = 0; i < j; i++) {
            count += i;
        }
        return count;
//        return ((i*(i-1))/2);
    }
}
