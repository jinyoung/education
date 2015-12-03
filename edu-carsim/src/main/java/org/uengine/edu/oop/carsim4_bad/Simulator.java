package org.uengine.edu.oop.carsim4_bad;

import org.uengine.edu.oop.carsim2.Car;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class Simulator {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Car theCar = (Car) Class.forName("org.uengine.edu.oop.carsim2.models."
                + args[0]).newInstance();

        System.out.println("Car Model is " + args[0]);

        for(int i=0; i<10; i++) {
            theCar.accelerateOneSecond();

            System.out.println(""+ i +  "sec. speed is " + theCar.getCurrentSpeed()
                    + " and the fuel economy is " + theCar.getCurrentFuelEconomy());
        }


        for(int i=0; i<10; i++) {

            theCar.setCurrentSpeed(theCar.getCurrentSpeed() * 0.9);             ///    <=================================
            theCar.setRunningTime(theCar.getRunningTime() + 1);                 ///    <=================================

            System.out.println("User press brake button for "+ i +  "sec. speed is " + theCar.getCurrentSpeed());
        }

    }
}
