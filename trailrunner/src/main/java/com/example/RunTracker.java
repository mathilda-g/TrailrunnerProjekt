package com.example;

public class RunTracker {

    private double distance;

    public void savedDistance(double distanceInKm) {
        if(distanceInKm <= 0) {
            throw new IllegalArgumentException("Distansen måste vara större än 0!");
        }

        this.distance = distanceInKm;
    }

    public double getSavedDistance() {
        return distance;
    }
    
}
