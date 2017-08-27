package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.*;


public class Main {

    static Cars car[] = new Cars[10];
    static Motorcycles motor[] = new Motorcycles[10];
    static Trucks truck[] = new Trucks[10];


    public static void main(String[] args) {

        createVehicles();

        ArrayList<Map>raceResult=simulateRace();
        printRaceResults(raceResult.get(0),raceResult.get(1),raceResult.get(2),raceResult.get(3));

    }

        public static void createVehicles(){

            // creates 10 cars, 10 trucks and 10 motorcycles
            for (int i = 0; i < 10; i++) {
                car[i] = new Cars();
                motor[i] = new Motorcycles(i);
                truck[i] = new Trucks();
            }
        }
        //simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
        public static ArrayList<Map> simulateRace() {

            //move  each vehicles for 50 hours
            for (int j = 1; j <= 50; j++) {

                //setting whether its raining
                boolean isRainingChance = isRaining();
                if (isRainingChance) {
                    Cars.setSpeedLimit(70);
                } else {
                    Cars.setSpeedLimit(0);
                }

                for (int i = 0; i < 10; i++) {
                    car[i].moveForAnHour();
                    motor[i].setSpeed(isRainingChance);
                    motor[i].moveForAnHour();
                    truck[i].moveForAnHour();
                }
            }

            //Save result in dictionary(Truckname : distancetraveled, Truckname : brakedowntime)
            HashMap<String, Integer> carsStat = new HashMap<>();
            HashMap<String, Integer> motorsStat = new HashMap<>();
            Map<String, Integer> truckStat = new HashMap<>();
            Map<String, Integer> brakeDownStat = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                carsStat.put(car[j].name, car[j].distanceTraveled);
                motorsStat.put(motor[j].name, motor[j].distanceTraveled);
                truckStat.put(truck[j].name, truck[j].distanceTraveled);
                brakeDownStat.put(truck[j].name,truck[j].breakdownTurnsLeft);
            }

            //return race simulator result in list
            ArrayList<Map> raceResult = new ArrayList<>();
            raceResult.add(carsStat);
            raceResult.add(motorsStat);
            raceResult.add(truckStat);
            raceResult.add(brakeDownStat);
            return raceResult;
    }


    //print result
    public static void printRaceResults(Map carsStat, Map motorsStat, Map truckStat, Map brakeDownStat){

        carsStat.forEach((key, value) -> out.println("Name of the Car: " + key + " Distance traveled : " + value));
        motorsStat.forEach((key,value) -> out.println("Name of the Motorcycle: " + key +" Distance traveled : " + value));
        truckStat.forEach((key,value) -> out.println("Name of the Truck:" + key + " Distance traveled: " + value + " Brake down time: " + brakeDownStat.get(key)));

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
