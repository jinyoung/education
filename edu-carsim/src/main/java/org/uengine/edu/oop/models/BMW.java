package org.uengine.edu.oop.models;

import org.uengine.edu.oop.Car;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class BMW extends Car{
    @Override
    public double getZeroToHundred() {
        return 5;
    }

    @Override
    public double getCurrentFuelEconomy() {
        return 100 / getCurrentSpeed();
    }
}
