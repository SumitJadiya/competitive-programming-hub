package com.sumit.coding.design_patterns.creational.abstractFactory.solution.factory;

import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.Pizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.CheesePizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.PepperoniPizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.solution.product.impl.VeggiePizza;

public class PizzaFactory {

    public static Pizza createPizza(String type) {

        Pizza pizza = null;

        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
