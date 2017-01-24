package org.uengine.edu.oop.carsim2.models;

import org.uengine.edu.oop.carsim2.Car;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class Tesla extends Car {

    @Override
    public void accelerateOneSecond() {
        setCurrentSpeed(240);
        setRunningTime(getRunningTime()+1);
    }

    public double getZeroToHundred() {
        return 0;
    }

    public double getCurrentFuelEconomy() {
        return 0;
    }
}
