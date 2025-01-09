package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestDistanceTracker {

    private DistanceTracker distanceTracker;

    @BeforeEach
    public void setUp() {
        distanceTracker = new DistanceTracker();
    }
    
    @Test
    public void saveValidDistanceCorrectly() {
        //setup
        double expectedDistance = 5.0;

        //code under test
        distanceTracker.savedDistance(expectedDistance);
        double actualDistance = distanceTracker.getSavedDistance();

        //assertions
        Assertions.assertEquals(expectedDistance, actualDistance);

    }

    @Test
    public void saveNegativeDistanceThrowsException() {

        //code under test
        double negativeDistance = -1.0;

        //Assertions
        Assertions.assertThrows(IllegalArgumentException.class, () -> distanceTracker.savedDistance(negativeDistance));
    }

   
}
