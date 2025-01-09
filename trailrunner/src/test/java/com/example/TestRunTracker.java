package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestRunTracker {
    
    @Test
    public void shouldSaveDistanceCorrectly() {
        //setup
        RunTracker runTracker = new RunTracker();
        double expectedDistance = 5.0;

        //code under test
        runTracker.savedDistance(expectedDistance);
        double actualDistance = runTracker.getSavedDistance();

        //assertions
        Assertions.assertEquals(expectedDistance, actualDistance);

    }
}
