package com.sumit.coding.design_patterns.structural.decorator.solution.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.solution.service.Pizza;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.ToppingDecorator;

public class Pepperoni extends ToppingDecorator {

    public Pepperoni(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 2.0;  // Pepperoni costs extra
    }
}
