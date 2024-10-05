package com.sumit.coding.design_patterns.structural.decorator.solution.service.impl;

import com.sumit.coding.design_patterns.structural.decorator.solution.service.Pizza;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.ToppingDecorator;

public class Cheese extends ToppingDecorator {

    public Cheese(Pizza newPizza) {
        super(newPizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " + Cheese";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 1.5; // cheese cost extra
    }
}
