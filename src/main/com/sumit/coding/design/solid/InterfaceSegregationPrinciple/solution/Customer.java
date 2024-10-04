package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution;

public class Customer implements Orderable {
    @Override
    public void orderFood() {
        System.out.println("Customer orders food.");
    }
}
