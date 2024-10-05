package com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution.service.impl;

import com.sumit.coding.design.solid.InterfaceSegregationPrinciple.solution.service.Serveable;

public class Waiter implements Serveable {
    @Override
    public void serveFood() {
        System.out.println("Waiter serves food.");
    }
}
