package com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.problem;

public class NotificationService {

    public void sendNotification(String type, String message) {
        if (type.equals("Email")) {
            System.out.println("Sending email: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        } else {
            System.out.println("default");
        }
        // To add a new notification type, like push notification,
        // you'll need to modify this method, which violates Open/Closed Principle
        // Drawback: Every time a new notification method is added, you have to modify the NotificationService class, making the system rigid and hard to extend.
    }
}
