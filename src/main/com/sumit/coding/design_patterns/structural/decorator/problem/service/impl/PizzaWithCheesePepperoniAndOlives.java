package com.sumit.coding.design_patterns.structural.decorator.problem.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.problem.service.Pizza;

public class PizzaWithCheesePepperoniAndOlives extends Pizza {

    @Override
    public String getDescription() {
        return super.getDescription() + " + Cheese + Pepperoni + Olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 4.5;  // Cheese, Pepperoni, and Olives cost extra
    }
}
