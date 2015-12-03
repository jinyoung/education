package org.uengine.edu.oop.carsim2;

/**
 * Created by jjy on 2015. 12. 2..
 */
public abstract class Car {

    double currentSpeed = 0;
        public double getCurrentSpeed() {
            return currentSpeed;
        }
        public void setCurrentSpeed(double currentSpeed) {
            if(currentSpeed > 250) return;

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
}
