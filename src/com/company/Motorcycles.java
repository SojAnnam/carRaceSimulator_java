package com.company;

import java.util.Random;

public class Motorcycles {

    int speed =100;
    String name;
    int distanceTraveled;
    private int lowSpeed = 5;
    private int highSpeed = 50;


    public Motorcycles( int nameNumber){

        name = new StringBuilder("Motorcycle").append(" ").append(nameNumber+1).toString();

    }

    //If rains, travels with 5-50km/h slower (randomly)
    public void setSpeed(boolean isRaining){
        if (isRaining){
            Random randomChance = new Random();
            int randomSpeedSlower = randomChance.nextInt(highSpeed-lowSpeed) + lowSpeed;
            speed -= randomSpeedSlower;
        }else{
            speed = 100;
        }
    }

    public void moveForAnHour(){

        distanceTraveled += speed;
    }


}



