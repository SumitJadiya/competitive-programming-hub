package com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.impl;

import com.sumit.coding.designPrinciple.solid.InterfaceSegregationPrinciple.solution.service.Cookable;

public class Chef implements Cookable {
    @Override
    public void cookFood() {
        System.out.println("Chef cooks food.");
    }
}
