package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {




    public static void main(String[] args) {
        Car car_container[] = new Car[10];
        for (int i=0; i<9; i++){
            car_container[i] = new Car(carName());
            for (int j =1; j<=50; j++){
                car_container[i].moveForAnHour();
            }
            System.out.println(car_container[i].name);
            System.out.println(car_container[i].distancetravel);
        }




    }


    public static String carName(){
        List<String> carNamesList = Arrays.asList(  "Centaur", "Majesty","Utopia",
                                                    "Scorpion","Scorpion", "Nimbus",
                                                    "Zeal", "Mammoth","Olympian",
                                                    "Serpent", "Paradox", "Phantom",
                                                    "Cosmos", "Universe", "Harmony",
                                                    "Moonlight", "Baron", "Dusk",
                                                    "Aurora", "Icon", "Momentum");

        Random randomChance = new Random();
        int firstname = randomChance.nextInt(carNamesList.size());
        int secondname = randomChance.nextInt(carNamesList.size());
        String name = new StringBuilder(carNamesList.get(firstname)).append(" ").append(carNamesList.get(secondname)).toString();
        return name;

    }
}
