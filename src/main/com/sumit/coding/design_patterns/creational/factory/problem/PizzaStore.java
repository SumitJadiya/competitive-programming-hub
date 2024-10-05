package com.sumit.coding.design_patterns.creational.factory.problem;

import com.sumit.coding.design_patterns.creational.factory.problem.product.Pizza;
import com.sumit.coding.design_patterns.creational.factory.problem.product.impl.CheesePizza;
import com.sumit.coding.design_patterns.creational.factory.problem.product.impl.PepperoniPizza;
import com.sumit.coding.design_patterns.creational.factory.problem.product.impl.VeggiePizza;

public class PizzaStore {

    public void orderPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();

        // Order Cheese Pizza
        store.orderPizza("cheese");
        System.out.println();
        // Order Pepperoni Pizza
        store.orderPizza("pepperoni");
        System.out.println();
        // Order Veggie Pizza
        store.orderPizza("veggie");
    }
}

/*
    Problems with This Approach:

	1.	Tight Coupling: The PizzaStore class is tightly coupled with the specific pizza classes (CheesePizza, PepperoniPizza, VeggiePizza). Every time you add a new pizza type, you have to modify the PizzaStore class.
	2.	Violation of the Open-Closed Principle: If you want to add a new pizza type (e.g., BBQPizza), you have to modify the PizzaStore class, violating the Open-Closed Principle (classes should be open for extension but closed for modification).
	3.	Duplication of Creation Logic: Object creation logic (if-else or switch) is duplicated every time you need to create different types of pizza in other parts of the code.
	4.	Inflexibility: It is difficult to manage changes if you want to change the way pizzas are created or add/remove pizzas without altering the client code.
* */