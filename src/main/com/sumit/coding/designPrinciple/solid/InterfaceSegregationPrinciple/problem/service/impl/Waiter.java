package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.impl;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.RestaurantUser;

public class Waiter implements RestaurantUser {
    @Override
    public void orderFood() {
        // Unused method
    }

    @Override
    public void cookFood() {
        // Unused method
    }

    @Override
    public void serveFood() {
        System.out.println("Waiter serves food.");
    }
}
