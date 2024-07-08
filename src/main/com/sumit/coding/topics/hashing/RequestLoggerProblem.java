package main.com.sumit.coding.topics.hashing;

import java.util.HashMap;
import java.util.Map;

public class RequestLoggerProblem {

    int timeLimit;
    Map<String, Integer> map;

    public RequestLoggerProblem(int timeLimit) {
        this.timeLimit = timeLimit;
        this.map = new HashMap<>();
    }

    public boolean messageRequestDecision(int timestamp, String request) {
        if (map.containsKey(request))
            if (timestamp - map.get(request) < timeLimit)
                return false;

        map.put(request, timestamp);
        return true;
    }

    public static void main(String[] args) {
        RequestLoggerProblem requestLoggerProblem = new RequestLoggerProblem(7);
        Map<Integer, String> inputMap = Map.of(
                1, "good morning", 5, "good morning", 9, "i need coffee", 10, "hello world", 11, "good morning", 15, "i need coffee", 17, "hello world", 25, "i need coffee");

        inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Request Accepted : " + requestLoggerProblem.messageRequestDecision(entry.getKey(), inputMap.get(entry.getKey()))));
    }
}