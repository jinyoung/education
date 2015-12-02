package org.uengine.edu.oop;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class Simulator {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Car theCar = (Car) Class.forName("org.uengine.edu.oop.models." + args[0]).newInstance();

        for(int i=0; i<100; i++) {
            theCar.accelerateOneSecond();

            System.out.println(""+ i +  "sec. speed is " + theCar.getCurrentSpeed() + " and the fuel economy is " + theCar.getCurrentFuelEconomy());
        }


    }
}
