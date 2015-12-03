package org.uengine.edu.oop.carsim1;


/**
 * Created by jjy on 2015. 12. 2..
 */
public class Simulator{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        if("BMW".equals(args[0])){
            simulate("BMW", 5);

        }else if("Benz".equals(args[0])){
            simulate("Benz", 8);

        }

    }

    public static void simulate(String modelName, double zeroToHundred){
        System.out.println("Car Model is " + modelName);


        for(int i=0; i<10; i++) {
            double speed = (100 / zeroToHundred) * i;

            System.out.println(""+ i +  "sec. speed is " + speed);
        }
    }

}

