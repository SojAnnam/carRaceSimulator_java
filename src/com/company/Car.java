package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car {
    String name;
    int normalspeed;
    int distancetravel;
    int speed;

    public Car (String name){
        this.name = name;
        normalspeed = normalSpeed();
    }


    public void setSpeedLimit(int limit){
        Random randomChance = new Random();
        int x = randomChance.nextInt(100);
        if (x<=30){
            normalspeed = limit;
        }


    }
    private Integer normalSpeed(){
        Random randomChance = new Random();
        int x = randomChance.nextInt(30);
        int setNormalSpeed = 110-x;
        return setNormalSpeed;
    }



    public void moveForAnHour(){
        distancetravel = distancetravel + normalspeed;
    }





}
