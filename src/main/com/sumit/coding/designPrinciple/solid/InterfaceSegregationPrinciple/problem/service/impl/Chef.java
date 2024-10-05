package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.impl;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.problem.service.RestaurantUser;

public class Chef implements RestaurantUser {
    @Override
    public void orderFood() {
        // Unused method
    }

    @Override
    public void cookFood() {
        System.out.println("Chef cooks food.");
    }

    @Override
    public void serveFood() {
        // Unused method
    }
}
