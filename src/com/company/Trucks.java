package com.company;

import java.util.Random;

public class Trucks {
    int speed =100;
    String name;
    int distanceTraveled;
    int breakdownTurnsLeft;


    public Trucks(){
        Random randomChance = new Random();
        int randomNameNumber = randomChance.nextInt(1000);
        name = new StringBuilder("Truck").append(" ").append(randomNameNumber).toString();
    }


    public void moveForAnHour() {
        //5% chance of breaking down for 2 hours
        if (breakdownTurnsLeft % 2 == 0) {
            Random randomChance = new Random();
            int brakeDownChance = randomChance.nextInt(100);
            if (brakeDownChance<=5) {
                breakdownTurnsLeft += 1;
            }else {
                distanceTraveled += speed;
            }
        }else {
            breakdownTurnsLeft += 1;
        }

    }
}
