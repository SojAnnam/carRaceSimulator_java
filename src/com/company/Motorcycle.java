package com.company;

import java.util.Random;

public class Motorcycle extends Vehicles {

    private int lowSpeed = 5;
    private int highSpeed = 50;


    public Motorcycle(int nameNumber){
        name = new StringBuilder("Motorcycle").append(" ").append(nameNumber+1).toString();
        speed =100;

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
    @Override
    public void moveForAnHour(){

        distanceTraveled += speed;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "name='" + name + '\'' +
                ", distanceTraveled=" + distanceTraveled +
                '}';
    }
}



