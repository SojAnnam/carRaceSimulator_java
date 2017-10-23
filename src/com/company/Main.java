package com.company;

import java.util.*;

import static java.lang.System.*;


public class Main {

    static Car car[] = new Car[10];
    static Motorcycle motor[] = new Motorcycle[10];
    static Truck truck[] = new Truck[10];


    public static void main(String[] args) {

        createVehicles();

        simulateRace();
        printRaceResults();

    }

        public static void createVehicles(){

            // creates 10 cars, 10 trucks and 10 motorcycles
            for (int i = 0; i < 10; i++) {
                car[i] = new Car();
                motor[i] = new Motorcycle(i);
                truck[i] = new Truck();
            }
        }
        //simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
        public static void simulateRace() {

            //move  each vehicles for 50 hours
            for (int j = 1; j <= 50; j++) {

                //setting whether its raining
                boolean isRainingChance = isRaining();
                if (isRainingChance) {
                    Car.setSpeedLimit(70);
                } else {
                    Car.setSpeedLimit(0);
                }

                for (int i = 0; i < 10; i++) {
                    car[i].moveForAnHour();
                    motor[i].setSpeed(isRainingChance);
                    motor[i].moveForAnHour();
                    truck[i].moveForAnHour();
                }
            }
    }


    //print result
    public static void printRaceResults(){
        for (int i = 0; i < 10; i++) {
            System.out.println(car[i].toString());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(motor[i].toString());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(truck[i].toString());
        }
    }

    //30% chance of rain every hour
    public static boolean isRaining(){
        Random randomChance = new Random();
        int x = randomChance.nextInt(100);
        if(x <= 30) {
            return true;
        }else {
            return false;
        }

    }


}
