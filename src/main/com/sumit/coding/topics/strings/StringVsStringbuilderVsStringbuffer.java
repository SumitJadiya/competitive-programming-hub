package main.com.sumit.coding.topics.strings;

import java.util.Arrays;

/*
 * Use String for scenarios where the string value is not modified frequently.
 * Use StringBuffer when you need to work with mutable strings in a multithreaded context.
 * Use StringBuilder when you are working with mutable strings in a single-threaded context or when thread safety is not a concern.
 *
 * O/P -
 * Time taken with String: 22022 ms
 * Time taken with StringBuilder: 11 ms
 * Time taken with StringBuffer: 13 ms
 * */
public class StringVsStringbuilderVsStringbuffer {

    public static void main(String[] args) {
        String[] strings = new String[1000000];
        Arrays.fill(strings, "a");

        long startTime = System.currentTimeMillis();
        concatenateWithString(strings);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with String: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        concatenateWithStringBuilder(strings);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        concatenateWithStringBuffer(strings);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuffer: " + (endTime - startTime) + " ms");
    }

    public static String concatenateWithString(String[] strings) {
        String result = "";
        for (String str : strings) {
            result += str;
        }
        return result;
    }

    public static String concatenateWithStringBuilder(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}
