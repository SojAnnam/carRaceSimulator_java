package com.company;

import java.util.*;


public class Main {




    public static void main(String[] args) {
        LinkedList<String>namesOfCarsList = new LinkedList<String>();
        Car car_container[] = new Car[10];
        for (int i=0; i<9; i++){
            car_container[i] = new Car();
            for (int j =1; j<=50; j++){
                car_container[i].setSpeedLimit(70);
                car_container[i].moveForAnHour();
            }
            System.out.println(car_container[i].name);
            System.out.println(car_container[i].distancetravel);
        }




    }


}
