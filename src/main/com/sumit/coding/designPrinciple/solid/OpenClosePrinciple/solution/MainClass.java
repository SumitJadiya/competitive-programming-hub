package com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution;

import com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.Notification;
import com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.NotificationService;
import com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.impl.EmailNotification;
import com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.impl.PushNotification;
import com.sumit.coding.designPrinciple.solid.OpenClosePrinciple.solution.service.impl.SMSNotification;

public class MainClass {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();
        Notification pushNotification = new PushNotification();

        service.send(emailNotification, "Welcome to our service!");
        service.send(smsNotification, "Your order has been shipped.");
        service.send(pushNotification, "You have a new message.");  // New type, no changes to existing code
    }
}
