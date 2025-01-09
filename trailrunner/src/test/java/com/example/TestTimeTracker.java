package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class TestTimeTracker {

    private TimeTracker timeTracker;

    @BeforeEach
    public void setUp() {
        timeTracker = new TimeTracker(1, 30, 30);
    }

    @Test
    public void constructorValidTime() {
        //Code under test
        int hours = timeTracker.getHours();
        int minutes = timeTracker.getMinutes();
        int seconds = timeTracker.getSeconds();

        //Assertions
        Assertions.assertEquals(2, hours);
        Assertions.assertEquals(30, minutes);
        Assertions.assertEquals(15, seconds);

    }

    @Test
    public void constructorInvalidTimeNegativeHours() {
       //Code under test
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeTracker(-1, 30, 15);
       });

       //Assertions
       Assertions.assertEquals("Ogiltlig tid, timmar, minuter och sekunder måste vara inom tillåtet intervall", exception.getMessage());
    }

    @Test
    public void constructorInvalidTimeInvalidMinutes() {
        //Code under test
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeTracker(2, 60, 15);
        });

        //Assertions
        Assertions.assertEquals("Ogiltlig tid, timmar, minuter och sekunder måste vara inom tillåtet intervall", exception.getMessage());
    }

    @Test
    public void constructorInvalidTimeInvalidSeconds() {
        //Code under test
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeTracker(2, 30, 60);
        });

        //Assertions
        Assertions.assertEquals("Ogiltlig tid, timmar, minuter och sekunder måste vara inom tillåtet intervall", exception.getMessage());
    }


    @Test
    public void validSetTime() {
        //Code under test
        timeTracker.setTime(6, 20, 30);

        //Assertions
        Assertions.assertEquals(6, timeTracker.getHours());
        Assertions.assertEquals(20, timeTracker.getMinutes());
        Assertions.assertEquals(30, timeTracker.getSeconds());

    }

    // Testa setTime-metoden med negativa minuter
    @Test
    public void setTimeInvalidNegativeMinutes() {
        //Code under test
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            timeTracker.setTime(2, -1, 15);
        });

        //Assertions
        Assertions.assertEquals("Ej giltlig tid", exception.getMessage());
    }

    @Test
    public void testToSeconds() {
        //code under test
        int totalSeconds = timeTracker.toSeconds();

        //Assertions
        Assertions.assertEquals(5430, totalSeconds);
    }

    
    
}
