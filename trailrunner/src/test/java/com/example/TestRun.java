package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestRun {

    private Distance distance;
    private Time time;
    private Date date;
    private Run run;
    
    
    @BeforeEach
    public void setUp() {
        distance = new Distance(5.5);
        time = new Time(1, 30, 15);
        date = new Date("2025-01-13");
        run = new Run("LÖPRUNDA123", distance, time, date);

    }

    @Test
    public void shouldCreateRunWithUniqueId()  {
        
        Run run1 = new Run(null, distance, time, date);
        Run run2 = new Run(null, distance, time, date);

        Assertions.assertNotEquals(run1.getRunId(), run2.getRunId());

    }

    @Test
    public void shouldThrowExceptionForDuplicateId() {
        
        String duplicateId = "LÖPRUNDA123";
        new Run(duplicateId, distance, time, date);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Run(duplicateId, distance, time, date);
        });

    }

    @Test
    public void shouldStoreGivenValidId() {
        Run run = new Run("LÖPRUNDA001", distance, time, date);

        Assertions.assertEquals("LÖPRUNDA001", run.getRunId());

    }

    @Test
    public void testToStringMethod() {
        String expected = "Run{id='LÖPRUNDA123', distance=5,5 km, time=01:30:15, date=2025-01-13}";
        
        Assertions.assertEquals(expected, run.toString());
    }
    

}
