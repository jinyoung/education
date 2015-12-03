package org.uengine.edu.oop.carsim2.models;

import org.uengine.edu.oop.carsim2.Car;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class Hyundai extends Car{
    @Override
    public double getZeroToHundred() {
        return 3;
    }

    @Override
    public double getCurrentFuelEconomy() {
        return 300 / getCurrentSpeed();
    }
}

