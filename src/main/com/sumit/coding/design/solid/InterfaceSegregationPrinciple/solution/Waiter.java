package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution;

public class Waiter implements Serveable {
    @Override
    public void serveFood() {
        System.out.println("Waiter serves food.");
    }
}
