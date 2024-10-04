package com.sumit.coding.design.solid.OpenClosePrinciple.solution.service;

public class NotificationService {

    public void send(Notification notification, String message) {
        notification.notify(message);
    }
}
