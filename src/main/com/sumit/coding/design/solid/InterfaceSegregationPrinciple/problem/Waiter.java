package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.problem;

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
