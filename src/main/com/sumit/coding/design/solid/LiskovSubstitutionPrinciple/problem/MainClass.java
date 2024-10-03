package com.sumit.coding.design.solid.LiskovSubstitutionPrinciple.problem;

import java.util.ArrayList;
import java.util.List;

/*
 * If you swap (substitute) the child with parent then the code must not fail.
 * */

public class MainClass {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new MotorCycle());
        vehicles.add(new Car());
        vehicles.add(new BiCycle());

        for (Vehicle vehicle : vehicles)
            System.out.println(vehicle.hasEngine().toString()); // this will break for BiCycle as hasEngine is null
    }
}
