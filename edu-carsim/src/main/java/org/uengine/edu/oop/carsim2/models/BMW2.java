package org.uengine.edu.oop.carsim2.models;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class BMW2 extends BMW{

    @Override
    public double getCurrentFuelEconomy() {
        return super.getCurrentFuelEconomy() * 2;
    }
}


