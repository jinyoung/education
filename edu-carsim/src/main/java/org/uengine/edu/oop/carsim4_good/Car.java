package org.uengine.edu.oop.carsim4_good;

/**
 * Created by jjy on 2015. 12. 2..
 */
public abstract class Car {

    double currentSpeed = 0;
        public double getCurrentSpeed() {
            return currentSpeed;
        }
        private void setCurrentSpeed(double currentSpeed) {      ///    <=================================
            if(currentSpeed > 250) throw new IllegalArgumentException("over 250 is not allowed.");

            this.currentSpeed = currentSpeed;
        }

    int runningTime = 0;
        public int getRunningTime() {
            return runningTime;
        }

        public void setRunningTime(int runningTime) {
            this.runningTime = runningTime;
        }

    public void accelerateOneSecond(){
        setCurrentSpeed((100 / getZeroToHundred()) * getRunningTime() );
        setRunningTime(getRunningTime() + 1);
    }

    abstract public double getZeroToHundred();

    abstract public double getCurrentFuelEconomy();

    public void brake(){                                           ///    <=================================
        setCurrentSpeed(getCurrentSpeed() * 0.9);
        setRunningTime(getRunningTime() + 1);
    }
}
