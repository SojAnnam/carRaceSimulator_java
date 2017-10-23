package com.company;

public abstract class Vehicles {

    String name = null;
    int speed = 0;
    int distanceTraveled = 0;

    public  void distanceWithSpeed(){distanceTraveled = distanceTraveled + speed;}
    public abstract void moveForAnHour();
    public abstract String toString();


}
