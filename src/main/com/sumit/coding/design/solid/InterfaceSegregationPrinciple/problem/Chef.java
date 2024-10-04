package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.problem;

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
