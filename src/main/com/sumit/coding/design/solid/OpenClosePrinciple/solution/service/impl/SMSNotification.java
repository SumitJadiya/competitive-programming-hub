package com.sumit.coding.design.solid.OpenClosePrinciple.solution.service.impl;

import com.sumit.coding.design.solid.OpenClosePrinciple.solution.service.Notification;

public class SMSNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("Sending SMS - " + message);
    }
}