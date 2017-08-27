package com.company;

import java.util.*;


public class Main {

    public static void main(String[] args) {


        Car car_container[] = new Car[10];
        for (int i = 0; i < 10; i++) {
            car_container[i] = new Car();


        }
        for (int j = 1; j <= 50; j++) {
            for (int i = 0; i < 10; i++) {
                if (isRaining()) {
                    car_container[i].setSpeedLimit(70);
                    car_container[i].moveForAnHour();
                } else {
                    car_container[i].moveForAnHour();
                }
            }

        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Name of the Car: " + car_container[i].name);
            System.out.println(" Distance traveled :"+ car_container[i].distanceTraveled);
        }

        Motorcycle motor[] = new Motorcycle[10];
        for (int numberOfMotor = 0; numberOfMotor < 10; numberOfMotor++) {
            motor[numberOfMotor] = new Motorcycle(numberOfMotor);

        }
        for (int s = 1; s <= 50; s++) {
            boolean isRainingChance = isRaining();
            for (int numberOfMotor = 0; numberOfMotor < 10; numberOfMotor++) {
                motor[numberOfMotor].setSpeed(isRainingChance);
                motor[numberOfMotor].moveForAnHour();
            }
        }
        for (int numberOfMotor = 0; numberOfMotor < 10; numberOfMotor++) {

            System.out.println( " Name of the Motorcycle: " + motor[numberOfMotor].name);
            System.out.println("Distance traveled: " + motor[numberOfMotor].distanceTraveled);
        }


        Truck truck[] = new Truck[10];
        for (int numberOfTruck = 0;numberOfTruck< 10; numberOfTruck++){
            truck[numberOfTruck] = new Truck();

        }
        for (int s = 1; s <= 50; s++) {
            for (int numberOfTruck = 0; numberOfTruck < 10; numberOfTruck++) {
                truck[numberOfTruck].moveForAnHour();
            }
        }
        HashMap<String, Integer> truckStat = new HashMap<>();
        for (int numberOfTruck = 0; numberOfTruck < 10; numberOfTruck++) {
            truckStat.put(truck[numberOfTruck].name,truck[numberOfTruck].distanceTraveled);
            System.out.println("Name of the Truck: "+ truck[numberOfTruck].name);
            System.out.println("Brake down time: " + truck[numberOfTruck].breakdownTurnsLeft);
            System.out.println("Distance traveled : " + truck[numberOfTruck].distanceTraveled);

        }
    }


    public static boolean isRaining(){
        Random randomChance = new Random();
        int x = randomChance.nextInt(100);
        return x <= 30;
    }


}
