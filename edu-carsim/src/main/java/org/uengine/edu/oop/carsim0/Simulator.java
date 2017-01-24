package org.uengine.edu.oop.carsim0;


/**
 * Created by jjy on 2015. 12. 2..
 */
public class Simulator {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String modelName = args[0];
        int zeroToHundred = 0;

        System.out.println("Car Model is " + modelName);

        if("BMW".equals(args[0])){

            zeroToHundred = 5;


        }else if("Benz".equals(args[0])){

            zeroToHundred = 8;


        }

        for(int i=0; i<10; i++) {
            double speed = (100 / zeroToHundred) * i;

            System.out.println(""+ i +  "sec. speed is " + speed);
        }


    }

}



