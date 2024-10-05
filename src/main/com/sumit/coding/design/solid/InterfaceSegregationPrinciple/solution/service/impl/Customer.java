package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution.service.impl;

import com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution.service.Orderable;

public class Customer implements Orderable {
    @Override
    public void orderFood() {
        System.out.println("Customer orders food.");
    }
}
