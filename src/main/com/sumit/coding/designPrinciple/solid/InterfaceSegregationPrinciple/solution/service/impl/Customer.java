package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.Orderable;

public class Customer implements Orderable {
    @Override
    public void orderFood() {
        System.out.println("Customer orders food.");
    }
}
