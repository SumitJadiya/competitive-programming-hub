package com.sumit.coding.design_patterns.structural.decorator.problem;

import com.sumit.coding.design_patterns.structural.decorator.problem.service.Pizza;
import com.sumit.coding.design_patterns.structural.decorator.problem.service.impl.PizzaWithCheeseAndPepperoni;

public class MainClass {

    public static void main(String[] args) {
        Pizza myPizza = new PizzaWithCheeseAndPepperoni(); // fixed combination
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // If the customer wants to add olives after choosing this, you'd need yet
        // another subclass like PizzaWithCheesePepperoniAndOlives, which isn't flexible.
    }
}

/*
    Problems with This Approach:

	1.	Class Explosion: Every combination of toppings (cheese, pepperoni, olives, etc.) requires a new subclass. As the number of toppings increases, the number of possible combinations (and therefore subclasses) grows exponentially.
    Example: With 3 toppings (cheese, pepperoni, olives), you would need 7 subclasses to represent all combinations.
	2.	Lack of Flexibility: Once a pizza is created (e.g., a pizza with cheese and pepperoni), you can’t add or remove toppings at runtime. To change the order, you would need a new subclass.
	3.	Code Duplication: Each subclass repeats similar logic for adding descriptions and calculating costs, resulting in duplicated code.
	4.	Violation of Open-Closed Principle: Every time a new topping is introduced (e.g., mushrooms), existing classes need to be modified or new subclasses created, violating the Open-Closed Principle
	(you should be able to extend behavior without modifying existing code).

    What If a Customer Wants:

	•	Pizza with cheese and olives?
	•	Pizza with pepperoni, olives, and mushrooms?

    You would have to create even more subclasses, which becomes unmanageable.

    The Decorator Pattern would solve this by allowing you to dynamically add toppings (decorators) to a pizza at runtime without needing a separate class for every combination of toppings,
    making the system far more flexible and maintainable.
* */