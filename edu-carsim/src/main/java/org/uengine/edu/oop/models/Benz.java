package org.uengine.edu.oop.models;

import org.uengine.edu.oop.Car;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class Benz extends Car{
    @Override
    public double getZeroToHundred() {
        return 8;
    }

    @Override
    public double getCurrentFuelEconomy() {
        return 200 / getCurrentSpeed();
    }
}
