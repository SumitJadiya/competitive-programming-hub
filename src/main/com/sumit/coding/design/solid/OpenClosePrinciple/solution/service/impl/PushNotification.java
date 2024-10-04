package com.sumit.coding.design.solid.OpenClosePrinciple.solution.service.impl;

import com.sumit.coding.design.solid.OpenClosePrinciple.solution.service.Notification;

public class PushNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("Sending Push - " + message);
    }
}
