package main.com.sumit.coding.companies.google.InterviewProcess;

import java.util.HashSet;

/*
* Problem URL :
* https://leetcode.com/problems/unique-email-addresses/
*
* Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
* Output: 2
* Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
* */
public class UniqueEmailAddressProblem {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> fullStr = new HashSet<>();

        for (String email : emails) {
            String[] arr = email.split("@");
            String[] parts = arr[0].split("\\+");

            fullStr.add(parts[0].replace(".", "")+"@"+arr[1]);
        }
        System.out.println(fullStr);
        return fullStr.size();
    }
}
