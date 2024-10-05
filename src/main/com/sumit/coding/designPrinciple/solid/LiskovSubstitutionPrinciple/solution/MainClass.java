package com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution;

import com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution.service.*;
import com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution.service.impl.BiCycle;
import com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution.service.impl.Car;
import com.sumit.coding.designPrinciple.solid.LiskovSubstitutionPrinciple.solution.service.impl.MotorCycle;

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
