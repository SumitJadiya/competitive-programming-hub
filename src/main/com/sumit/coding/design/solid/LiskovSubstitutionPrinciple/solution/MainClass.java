package com.sumit.coding.design.solid.LiskovSubstitutionPrinciple.solution;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new MotorCycle());
        vehicles.add(new Car());
        vehicles.add(new BiCycle());

        for (Vehicle vehicle : vehicles)
            System.out.println(vehicle.getNumberOfWheels().toString());

        List<EngineVehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new MotorCycle());
        vehicleList.add(new Car());
//        vehicleList.add(new BiCycle());

        for (EngineVehicle engineVehicle : vehicleList)
            System.out.println(engineVehicle.hasEngine().toString());
    }
}
