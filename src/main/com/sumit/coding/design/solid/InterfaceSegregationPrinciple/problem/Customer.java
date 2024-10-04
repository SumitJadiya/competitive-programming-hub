package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.problem;

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