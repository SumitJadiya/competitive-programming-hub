package main.com.sumit.coding.strings;

public class StringsIntroduction {
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        // or String s= new String ("GeeksforGeeks");

        // Returns the number of characters in the String.
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = " + s.charAt(3));

        // Return the substring from the ith index character to end of string
        System.out.println("Substring " + s.substring(3));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring from i to j-1 = " + s.substring(2, 5));

        // Concatenates string2 to the end of string1.
        String s1 = "Geeks";
        String s2 = "forGeeks";
        System.out.println("Concatenated string = " + s1.concat(s2));

        // Returns the index within the string of the first occurrence of the specified string.
        String s4 = "Learn Share Learn";
        System.out.println("Index of Share " + s4.indexOf("Share"));

        // Returns the index within the string of the first occurrence of the specified string, starting at the specified index.
        System.out.println("Index of a = " + s4.indexOf('a', 3));

        // Checking equality of Strings
        System.out.println("Checking Equality " + "Geeks".equals("geeks"));
        System.out.println("Checking Equality " + "Geeks".equals("Geeks"));
        System.out.println("Checking Equality " + "Geeks".equalsIgnoreCase("gEeks "));

        System.out.println("If s1 = s2 " + s1.compareTo(s2));

        // Converting cases
        String word1 = "GeeKyMe";
        System.out.println("Changing to lower Case " + word1.toLowerCase());
        System.out.println("Changing to UPPER Case " + word1.toUpperCase());

        // Trimming the word
        String word4 = " Learn Share Learn ";
        System.out.println("Trim the word " + word4.trim());

        // Replacing characters
        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str2 = "feeksforfeeks".replace('f', 'g');
        System.out.println("Replaced f with g -> " + str2);

        System.out.println(getRotated("ABCAB", 3));
    }

    private static String getRotated(String A, int x) {

        int len = A.length();
        String front = A.substring(0, len - x);
        String back = A.substring(len - x, len);

        return back + front;
    }
}
