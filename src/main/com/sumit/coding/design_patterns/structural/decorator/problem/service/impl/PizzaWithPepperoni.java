package com.sumit.coding.design_patterns.structural.decorator.problem.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.problem.service.Pizza;

public class PizzaWithPepperoni extends Pizza {

    @Override
    public String getDescription() {
        return super.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;  // Pepperoni costs extra
    }
}
