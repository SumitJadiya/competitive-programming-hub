package main.com.sumit.coding.topics.general;

public class MaskDigits {

    private static String maskData(String data, int visiblePrefixLength, int visibleSuffixLength) {
        String suffix = "";
        int dataLength = data.length();
        if (data.isBlank() || visiblePrefixLength + visibleSuffixLength >= dataLength) {
            return "input not valid";
        }

        if (data.contains("@")) {
            int index = data.indexOf("@");
            suffix = data.substring(index);
            data = data.substring(0, index);
            dataLength = data.length();
        }

        return data.substring(0, visiblePrefixLength) + "****" + data.substring(dataLength - visibleSuffixLength) + suffix;
    }

    public static void main(String[] args) {
        String data = "john.doe@example.com";
        System.out.println(maskData(data, 3, 2));

        data = "9834857734";
        System.out.println(maskData(data, 2, 3)); // Sen****ta
    }
}
