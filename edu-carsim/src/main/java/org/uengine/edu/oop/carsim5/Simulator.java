package org.uengine.edu.oop.carsim5;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.uengine.edu.oop.carsim4_good.Car;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class Simulator {

    Car car;
        public Car getCar() {
            return car;
        }
        public void setCar(Car car) {
            this.car = car;
        }

    public void simulate() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Car theCar = getCar();

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

    public static void main(String... args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:org/uengine/edu/oop/carsim5/applicationContext.xml");

        Simulator simulator = context.getBean(Simulator.class);
        simulator.simulate();

    }
}
