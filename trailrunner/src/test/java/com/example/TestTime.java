package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class TestTime {

    private Time time;

    @BeforeEach
    public void setUp() {
        time = new Time(1, 30, 20);
    }

    @Test
    public void shouldSetAndGetTimeCorrectly() {

        int hours = 1;
        int minutes = 30;
        int seconds = 20;

        time.setTime(hours, minutes, seconds);

        Assertions.assertEquals("01 timmar, 30 minuter, 20 sekunder", time.toString(), 
              "Tiden ska sparas i ett korrekt format");


    }

    @Test
    public void shouldThrowExceptionForNegativeValues() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> time.setTime(-1, 30, 20), 
             "Ska inte gå att spara ett negativt värde för timmar" 
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> time.setTime(1, -30, 20), 
             "Ska inte gå att spara ett negativt värde för minuter"
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> time.setTime(1, 30, -20),
              "Ska inte gå att spara ett negativt värde för sekunder"
        );

    }

    @Test
    public void shouldThrowExceptionForOutOfBoundsValues() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> time.setTime(1, 60, 20),
            "Minuter ska inte kunna vara över 59"
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> time.setTime(1, 30, 60),
            "Sekunder ska inte kunna vara över 59"
        );
    }
    




    
}
