package edu.trinity;

import java.time.Year;

public class Car {

    private String make;
    private String model;
    private Year year;
    private boolean running =  false;
    private int distanceCounter;
    public Car(String make, String model, Year year) {
        this.make =  make;
        this.model = model;
        this.year = year;

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }

    public boolean isRunning() {
        if (running){
            return true;
        }
        return false;
    }

    public void start() {
        if (!running) {
            running = true;
        }
    }

    public void stop() {
        if (running) {
            running = false;
        }
    }

    public void drive(int distance) {
        if (running) {
            distanceCounter += distance;
        }
    }


    public int getMiles() {
        return distanceCounter;
    }
}
