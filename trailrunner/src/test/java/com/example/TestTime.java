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


    @Test
    public void testToHoursWithWholeHoursOnly() {

        time.setTime(2, 0, 0);
        double expectedHours = 2.0;
        Assertions.assertEquals(expectedHours, time.toHours(), 0.01, "Tiden 2 timmar bör ge 2.0 timmar");

    }
    
    @Test
    public void testToHoursWithMinutesAndSeconds() {
        time.setTime(1, 30, 15);
       
        double expectedHours = 1 + (30 / 60.0) + (15 / 3600.0);
        Assertions.assertEquals(expectedHours, time.toHours(), 0.01, "Tiden 1 timme, 15 minuter och 30 sekunder bör konverteras korrekt");
    }

    @Test
    public void testToHoursWithZeroTime() {
             time.setTime(0, 0, 0);

             Assertions.assertEquals(0.0, time.toHours(), 0.01, "Tiden 0 timmar, 0 minuter och 0 sekunder borde ge 0.0 timmar");
    }
    




    
}
