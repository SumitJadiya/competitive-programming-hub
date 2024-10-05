package com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.problem;

public class MainClass {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.sendNotification("Email", "STJ@gmail.com");

        // This is not possible
        service.sendNotification("Push", "Hey! there");
    }
}
