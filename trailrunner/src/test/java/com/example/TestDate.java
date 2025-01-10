package com.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestDate {

    private String todaysDate;

    @BeforeEach
    public void setUp() {
    LocalDate todaysLocalDate = LocalDate.now();
    todaysDate = todaysLocalDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
}

    @Test
    public void saveRunWithoutSpecifiedDate() {

        String result = Date.saveDate(null);

        Assertions.assertEquals(todaysDate, result);
    }
    
        @Test
    public void shouldSaveDateForRunCorrectly() {
        
        String testDate = "2025-01-10";

        String result = Date.saveDate(testDate);

        Assertions.assertEquals(testDate, result);

    }

    @Test
    public void saveRunWithEmptyDate() {

        String result = Date.saveDate("");

        Assertions.assertEquals(todaysDate, result);
    }



}

