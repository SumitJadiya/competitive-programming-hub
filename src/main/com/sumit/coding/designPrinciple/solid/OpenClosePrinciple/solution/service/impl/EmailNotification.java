package com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.Notification;

public class EmailNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("Sending Email - " + message);
    }
}
