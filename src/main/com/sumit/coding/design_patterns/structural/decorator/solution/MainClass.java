package com.sumit.coding.design_patterns.structural.decorator.solution;

import com.sumit.coding.design_patterns.structural.decorator.solution.service.Pizza;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.impl.Cheese;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.impl.Olives;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.impl.Pepperoni;
import com.sumit.coding.design_patterns.structural.decorator.solution.service.impl.PlainPizza;

public class MainClass {

    public static void main(String[] args) {
        // Start with a plain pizza
        Pizza myPizza = new PlainPizza();
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // Add cheese dynamically
        myPizza = new Cheese(myPizza);
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // Add pepperoni dynamically
        myPizza = new Pepperoni(myPizza);
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // Add olives dynamically
        myPizza = new Olives(myPizza);
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());
    }
}

/*
    Benefits of Using the Decorator Pattern:

	1.	No Class Explosion: You no longer need to create separate classes for every possible combination of toppings. Each topping is its own class, and they can be combined dynamically at runtime.
	2.	Flexibility: You can add or remove toppings to any pizza dynamically by wrapping it with a new decorator object. The pizza object can be extended as many times as needed.
	3.	Open-Closed Principle: New toppings can be added without modifying existing code. Just create a new decorator (like Mushrooms) and use it without changing other parts of the system.
	4.	Reusable Components: Each topping decorator is independent and reusable. For example, the Cheese decorator can be applied to any pizza, and the logic for handling cheese stays in one place.
	5.	Runtime Configuration: The composition of a pizza can be determined at runtime, making it easy to customize based on user input.

    What Problems It Solves:

	•	Avoiding Class Explosion: There’s no need to create subclasses for each pizza-topping combination.
	•	Improving Maintainability: Adding new toppings doesn’t require changing existing pizza or topping classes.
	•	Extensibility: New toppings or variations can be added as separate decorators without affecting the core pizza or other toppings.

    In summary, the Decorator Pattern provides a flexible and scalable way to handle various pizza-topping combinations without the need to create a complex subclass hierarchy.
*
* */
