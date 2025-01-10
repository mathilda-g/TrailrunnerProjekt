package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestDistance {

    private Distance distance;

    @BeforeEach
    public void setUp() {
        distance = new Distance(5.0);
    }
    
    @Test
    public void shouldSetAndGetPositiveDistance() {
        //setup
        double testValue = 5.0;

        //code under test
        distance.setDistance(testValue);

        //assertions
        Assertions.assertEquals(testValue, distance.getDistance());

    }

    @Test
    public void shouldThrowExceptionForNegativeDistance() {   
        //Setup
        double negativeValue = -5.0;
        
        //Code under test och Assertions
        Assertions.assertThrows(IllegalArgumentException.class, () -> distance.setDistance(negativeValue), 
        "Ett negativt distansvärde ska inte tillåtas");

    }

    

   
}
