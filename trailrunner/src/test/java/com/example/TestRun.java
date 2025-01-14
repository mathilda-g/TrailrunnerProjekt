package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
    
    @BeforeEach
    public void clearExistingIds() {
        Run.clearExistingIds();
     
    }

    @BeforeEach
    public void resetState() {
        Run.resetState();
    }


    @Test
    public void shouldCreateRunWithUniqueId()  {
        
        Run run1 = new Run(null, distance, time, date);
        Run run2 = new Run(null, distance, time, date);

        Assertions.assertNotEquals(run1.getRunId(), run2.getRunId());

    }

    @Test
    public void shouldThrowExceptionForDuplicateId() {
        
        String duplicateId = "LÖPRUNDA002";
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
        String expected = String.format("Run{id='LÖPRUNDA123', distance=5,5 km, time=01:30:15, date=2025-01-13, avarageSpeed=3,66 km/h pace=16,41 min/km, fitnessScore=0}",
        run.getRunId(), run.getDistance().getDistance(), run.getTime(), run.getDate(),
        run.calcualteAverageSpeed(), run.calculatePace());
        
        Assertions.assertEquals(expected, run.toString());
    }
    
    @Test
    public void testCalculateAverageSpeed() {
        
        double expectedSpeed = 5.5 / (1 + (30 / 60.0) + (15 / 3600.0));
        
        Assertions.assertEquals(expectedSpeed, run.calcualteAverageSpeed(), 0.01);

    }

    @Test
    public void shouldCalculatePaceCorrectly() {

        Run run = new Run("LÖPRUNDA003", new Distance(5.0), new Time(0, 25, 0), new Date("2025-01-10"));
        double expectedPace = 5.0;
        Assertions.assertEquals(expectedPace, run.calculatePace(), 0.01, 
        "Kilometertiden bör vara 5.0 minuter per km");
    }

    @Test
    public void testCalculateFitnessScore_FirstRun() {

        int score = run.calculateFitnessScore();

        int expectedScore = (int) (5.5 + 16.41 * 3.66);

        Assertions.assertEquals(expectedScore, score);

    }

    @Test
    public void testCalculateFitnessScore_NegativeScoreNotAllowed() {

        run.calculateFitnessScore();
    
        Distance newDistance = new Distance(10.0);
        Time newTime = new Time(1, 15, 0);
        Date newDate = new Date("2030-01-01");

        Run run2 = new Run("LÖPRUNDA005", newDistance, newTime, newDate);

        int score2 = run2.calculateFitnessScore();

        Assertions.assertEquals(0, score2, "Fitness Score ska inte kunna bli negativt");

        }

    @Test
    public void testCurrentScoreIsUpdated() {

        run.calculateFitnessScore();

        int currentScore = Run.getCurrentScore();
        Assertions.assertTrue(currentScore > 0, "CurrentScore ska uppdateras efter varje löprunda");

        }

    @Test
    public void testCalculateTotalDistance() {

        new Run("LÖPRUNDA002", new Distance(5.0), new Time(1, 0, 0), new Date("2025-01-14"));

        double totalDistance = Run.calculateTotalDistance();

        Assertions.assertEquals(10.5, totalDistance);
    }

    @Test
    public void testCalculateAverageDistance() {

        new Run("LÖPRUNDA002", new Distance(5.0), new Time(1, 0, 0), new Date("2025-01-14"));

        double averageDistance = Run.calculateAverageDistance();

        Assertions.assertEquals(5.25, averageDistance);

    }

    @Test
    public void testFindRunById() {

        Optional<Run> foundRun = Run.findRunById("LÖPRUNDA123");

        Assertions.assertTrue(foundRun.isPresent());
        Assertions.assertEquals("LÖPRUNDA123", foundRun.get().getRunId());
    }

    @Test
    public void testDeleteRunById() {

        boolean deleted = Run.deleteRunById("LÖPRUNDA123");

        Assertions.assertTrue(deleted);
        Assertions.assertEquals(0, Run.getAllRuns().size(), "Listan ska vara tom efter radering.");

    }


    
    }






        


