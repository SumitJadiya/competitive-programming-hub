package com.sumit.coding.design_patterns.behavioral.strategy.solution;

public class MainClass {

    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();

        vehicle = new GoodsVehicle();
        vehicle.drive();
    }
}
