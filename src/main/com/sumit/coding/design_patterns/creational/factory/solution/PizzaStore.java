package com.sumit.coding.design_patterns.creational.factory.solution;

import com.sumit.coding.design_patterns.creational.factory.solution.factory.PizzaFactory;
import com.sumit.coding.design_patterns.creational.factory.solution.product.Pizza;

public class PizzaStore {

    public void orderPizza(String type) {
        Pizza pizza = PizzaFactory.createPizza(type);

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
    Benefits of Using the Factory Pattern:

	1.	Single Responsibility Principle: The PizzaStore class is no longer responsible for creating pizzas; that responsibility is delegated to the PizzaFactory class.
	2.	Open-Closed Principle: The PizzaStore class is closed for modification. To add a new pizza type (e.g., BBQPizza), you only need to modify the PizzaFactory class, not the client code.
	3.	Loose Coupling: The PizzaStore class is no longer tightly coupled to specific pizza implementations. If you add or remove pizzas, you don’t need to change the client code.
	4.	Scalability: The system becomes scalable. You can easily add new pizza types or change the creation logic without touching the core logic of the PizzaStore.
	5.	Centralized Creation Logic: Object creation is centralized in one place (the factory), making it easier to manage.

    Summary:

    The Factory Pattern helps solve the issue of tight coupling, duplicated creation logic, and rigid code that arises from directly instantiating objects in the client code.
    By delegating the creation of objects to a factory, the code becomes more maintainable, flexible, and open to extension without modification.
* */