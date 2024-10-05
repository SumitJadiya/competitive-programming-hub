package com.sumit.coding.designPrinciple.solid.DependencyInversionPrinciple.problem;


public class MainClass {

    public static void main(String[] args) {

        PetrolEngine petrolEngine = new PetrolEngine();
        Car petrolCar = new Car();
        petrolCar.startCar();  // Output: Petrol engine starting...

/*
        Every time a new engine type is added, you need to change the Car class, violating the Open/Closed Principle as well.

        DieselEngine dieselEngine = new DieselEngine();
        Car dieselCar = new Car();
        dieselEngine.startCar();  // Output: Diesel engine starting...
*/

    }
}
