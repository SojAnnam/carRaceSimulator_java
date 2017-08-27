package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.*;


public class Main {

    public static void main(String[] args) {
        ArrayList<Map>raceResult=simulateRace();
        printRaceResults(raceResult.get(0),raceResult.get(1),raceResult.get(2),raceResult.get(3));
        
    }

        public static void createVehicles(){
            //Car race
            //init 10 car for the race
            Cars car[] = new Cars[10];
            for (int i = 0; i < 10; i++) {
                car[i] = new Cars();
            }
            // motorcycle race
            //init 10 motorcycles
            Motorcycles motor[] = new Motorcycles[10];
            for (int numberOfMotor = 0; numberOfMotor < 10; numberOfMotor++) {
                motor[numberOfMotor] = new Motorcycles(numberOfMotor);
            }
            //Race of Truck
            //Init 10 truck
            Trucks truck[] = new Trucks[10];
            for (int numberOfTruck = 0; numberOfTruck < 10; numberOfTruck++) {
                truck[numberOfTruck] = new Trucks();
            }
        }

        public  static ArrayList<Map> simulateRace() {

            //Car race
            //init 10 car for the race
            Cars car[] = new Cars[10];
            for (int i = 0; i < 10; i++) {
                car[i] = new Cars();
            }

            //move  each car for 50 hours
            for (int j = 1; j <= 50; j++) {
                for (int i = 0; i < 10; i++) {
                    if (isRaining()) {
                        car[i].setSpeedLimit(70);
                        car[i].moveForAnHour();
                    } else {
                        car[i].moveForAnHour();
                    }
                }
            }

            //safe result in dictionary
            HashMap<String, Integer> carsStat = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                carsStat.put(car[i].name, car[i].distanceTraveled);
            }

            // motorcycle race
            //init 10 motorcycles
            Motorcycles motor[] = new Motorcycles[10];
            for (int numberOfMotor = 0; numberOfMotor < 10; numberOfMotor++) {
                motor[numberOfMotor] = new Motorcycles(numberOfMotor);
            }


            //each racer moves 50 hours
            for (int s = 1; s <= 50; s++) {
                boolean isRainingChance = isRaining();
                for (int numberOfMotor = 0; numberOfMotor < 10; numberOfMotor++) {
                    motor[numberOfMotor].setSpeed(isRainingChance);
                    motor[numberOfMotor].moveForAnHour();
                }
            }

            //safe result in dictionary
            HashMap<String, Integer> motorsStat = new HashMap<>();
            IntStream.range(0, 10).forEach(numberOfMotor -> {
                motorsStat.put(motor[numberOfMotor].name, motor[numberOfMotor].distanceTraveled);
            });



            //Race of Truck
            //Init 10 truck
            Trucks truck[] = new Trucks[10];
            for (int numberOfTruck = 0; numberOfTruck < 10; numberOfTruck++) {
                truck[numberOfTruck] = new Trucks();
            }

            // 50 hours race
            for (int s = 1; s <= 50; s++) {
                for (int numberOfTruck = 0; numberOfTruck < 10; numberOfTruck++) {
                    truck[numberOfTruck].moveForAnHour();
                }
            }

            //Safe result in dictionary(Truckname : distancetraveled, Truckname : brakedowntime)
            Map<String, Integer> truckStat = new HashMap<>();
            Map<String, Integer> brakeDownStat = new HashMap<>();
            for (int numberOfTruck = 0; numberOfTruck < 10; numberOfTruck++) {

                truckStat.put(truck[numberOfTruck].name, truck[numberOfTruck].distanceTraveled);
                brakeDownStat.put(truck[numberOfTruck].name,truck[numberOfTruck].breakdownTurnsLeft);
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
