package com.sumit.coding.design_patterns.creational.abstractFactory.problem.factory;

import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.Drink;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.Pizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.impl.CheesePizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.impl.Coke;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.impl.PepperoniPizza;
import com.sumit.coding.design_patterns.creational.abstractFactory.problem.product.impl.Pepsi;

public class ProductFactory {

    public static Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }

        return pizza;
    }

    public static Drink createDrink(String type) {
        Drink drink = null;

        if (type.equals("coke")) {
            drink = new Coke();
        } else if (type.equals("pepsi")) {
            drink = new Pepsi();
        }

        return drink;
    }
}
