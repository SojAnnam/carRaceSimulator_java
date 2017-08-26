package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car {
    String name;
    int normalspeed;
    int distanceTraveled;


    public Car (){
        name = carName();
        normalspeed = normalSpeed();
    }


    public void setSpeedLimit(int limit){
        normalspeed = limit;
    }
    private Integer normalSpeed(){
        Random randomChance = new Random();
        int x = randomChance.nextInt(30);
        int setNormalSpeed = 110-x;
        return setNormalSpeed;
    }



    public void moveForAnHour(){
        distanceTraveled = distanceTraveled + normalspeed;
    }
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




}
