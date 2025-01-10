package com.example;

public class Distance {

    private double distance;

    public void setDistance(double distance) {
        if(distance < 0) {
            throw new IllegalArgumentException("Distansen måste vara större än 0");
        }

        this.distance = distance;
    }

    public double getDistance() {
        return this.distance;
    }

}
