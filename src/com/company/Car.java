package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car extends Vehicles{


    static int limitSpeed = 0;
    private int lowSpeed = 80;
    private int highSpeed = 110;


    public Car(){
        this.name = carName();
        this.speed = normalSpeed();
    }

    //30% chance that they can go only with 70km/h speed.
    public static void setSpeedLimit(int limit){

        limitSpeed = limit;
    }

    //the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    private Integer normalSpeed(){

        Random randomChance = new Random();
        int randomNormalSpeed = randomChance.nextInt(highSpeed-lowSpeed) + lowSpeed;
        return randomNormalSpeed;
    }





    //set cars name
    private String carName(){
        List<String> carNamesList = Arrays.asList(  "Centaur", "Majesty","Utopia",
                "Scorpion","Scorpion", "Nimbus",
                "Zeal", "Mammoth","Olympian",
                "Serpent", "Paradox", "Phantom",
                "Cosmos", "Universe", "Harmony",
                "Moonlight", "Baron", "Dusk",
                "Aurora", "Icon", "Momentum");

        Random randomChance = new Random();
        int firstName;
        int secondName;
        String name;

        firstName = randomChance.nextInt(carNamesList.size());
        secondName = randomChance.nextInt(carNamesList.size());
        name = new StringBuilder(carNamesList.get(firstName)).append(" ").append(carNamesList.get(secondName)).toString();

        return name;
    }

    @Override
    public void moveForAnHour(){

        if(limitSpeed != 0){
            speed = limitSpeed;
        }

        distanceTraveled = distanceTraveled + speed;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distanceTraveled=" + distanceTraveled +
                '}';
    }
}
