package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.impl;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.RestaurantUser;

public class Customer implements RestaurantUser {
    @Override
    public void orderFood() {
        System.out.println("Customer orders food.");
    }

    @Override
    public void cookFood() {
        // Unused method
    }

    @Override
    public void serveFood() {
        // Unused method
    }
}
