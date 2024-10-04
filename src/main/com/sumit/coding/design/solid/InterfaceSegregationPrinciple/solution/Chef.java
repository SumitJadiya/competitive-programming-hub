package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution;

public class Chef implements Cookable {
    @Override
    public void cookFood() {
        System.out.println("Chef cooks food.");
    }
}
