package com.company;

import java.util.Random;

public class Truck extends Vehicles {

    String name;
    int breakdownTurnsLeft;


    public Truck(){
        Random randomChance = new Random();
        int randomNameNumber = randomChance.nextInt(1000);
        this.name = new StringBuilder("Truck").append(" ").append(randomNameNumber).toString();
        this.speed =100;
    }

    @Override
    public void moveForAnHour() {
        //5% chance of breaking down for 2 hours
        if (breakdownTurnsLeft % 2 == 0) {
            Random randomChance = new Random();
            int brakeDownChance = randomChance.nextInt(100);
            if (brakeDownChance<=5) {
                breakdownTurnsLeft += 1;
            }else {
                distanceWithSpeed();
            }
        }else {
            breakdownTurnsLeft += 1;
        }

    }

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + name + '\'' +
                ", distanceTraveled=" + distanceTraveled +
                ", breakdownTurnsLeft=" + breakdownTurnsLeft +
                '}';
    }
}
