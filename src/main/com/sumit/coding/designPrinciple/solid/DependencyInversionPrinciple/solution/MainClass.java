package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution;

import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.Engine;
import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.impl.DieselEngine;
import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.impl.ElectricEngine;
import com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.solution.service.impl.PetrolEngine;

public class MainClass {
    public static void main(String[] args) {
        // Injecting different engine types into the Car
        Engine petrolEngine = new PetrolEngine();
        Car petrolCar = new Car(petrolEngine);
        petrolCar.startCar();  // Output: Petrol engine starting...

        Engine dieselEngine = new DieselEngine();
        Car dieselCar = new Car(dieselEngine);
        dieselCar.startCar();  // Output: Diesel engine starting...

        Engine electricEngine = new ElectricEngine();
        Car electricCar = new Car(electricEngine);
        electricCar.startCar();  // Output: Electric engine starting...
    }
}
