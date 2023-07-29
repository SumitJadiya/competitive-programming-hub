package main.com.sumit.coding.topics.strings;

public class StringToCamelCaseProblem {

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCase("The_Stealth_Warrior"));
        System.out.println(toCamelCase("The_Stealth-Warrior"));
    }

    static String toCamelCase(String s) {

        int index = 0;
        boolean flag = false;
        StringBuffer sb = new StringBuffer();

        while (index < s.length()) {
            char ch = s.charAt(index++);

            if (ch == '-' || ch == '_')
                flag = true;
            else {
                sb.append((flag) ? Character.toUpperCase(ch) : ch);
                flag = false;
            }
        }


        return sb.toString();
    }
}
