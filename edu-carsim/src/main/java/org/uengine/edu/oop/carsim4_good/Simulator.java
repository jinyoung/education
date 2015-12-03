package org.uengine.edu.oop.carsim4_good;


/**
 * Created by jjy on 2015. 12. 2..
 */
public class Simulator {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Car theCar = (Car) Class.forName("org.uengine.edu.oop.carsim4_good.models."
                + args[0]).newInstance();

        System.out.println("Car Model is " + args[0]);

        for(int i=0; i<10; i++) {
            theCar.accelerateOneSecond();

            System.out.println(""+ i +  "sec. speed is " + theCar.getCurrentSpeed()
                    + " and the fuel economy is " + theCar.getCurrentFuelEconomy());
        }


        for(int i=0; i<10; i++) {
            theCar.brake();        ///    <=================================

            System.out.println("User press brake button for "+ i +  "sec. speed is " + theCar.getCurrentSpeed());
        }

    }
}
