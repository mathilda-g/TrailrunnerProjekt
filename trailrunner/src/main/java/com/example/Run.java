package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID; 

public class Run {

    private static int currentScore = 0;
    private static LocalDate lastRunDate = null;
    private static final Set<String> existingIds = new HashSet<>();
    private static final List<Run> allRuns = new ArrayList<>();

    private final String runId;
    private final Distance distance;
    private final Time time;
    private final Date date;

    //Konstruktor
    public Run(String runId, Distance distance, Time time, Date date) {
        if(runId == null || runId.isEmpty()) {
            runId = generateUniqueId();
        }else if(!isUniqueId(runId)) {
            throw new IllegalArgumentException("ID-numret existerar redan: " + runId);
        }

        this.runId = runId;
        this.distance = distance;
        this.time = time;
        this.date = date;
        existingIds.add(runId);
        allRuns.add(this);
    }

    private String generateUniqueId() {
        String uniqueId;
        do {
            uniqueId = UUID.randomUUID().toString();
        } while (!isUniqueId(uniqueId));
        return uniqueId;
    }

    public boolean isUniqueId(String id) {
        return !existingIds.contains(id);
    }

    public double calcualteAverageSpeed() {
        double hours = time.toHours();
        return hours > 0 ? distance.getDistance() / hours : 0;
    }

    public double calculatePace() {
        double toMinutes = time.toHours() * 60;
        return distance.getDistance() == 0 ? 0 : toMinutes / distance.getDistance();
    }

    public int calculateFitnessScore() {
        double avarageSpeed = calcualteAverageSpeed();
        double pace = calculatePace();
        double distanceValue = distance.getDistance();

        long daysSinceLastRun = (lastRunDate == null)
        ? 0
        : ChronoUnit.DAYS.between(lastRunDate, date.toLocalDate());

        int newScore = (int) (currentScore + (distanceValue + pace * avarageSpeed) - 2 * daysSinceLastRun);

        currentScore = Math.max(newScore, 0);
        lastRunDate = LocalDate.parse(date.toString());

        return currentScore;
        }

    public String getRunId() {
        return runId;
    }

    public Distance getDistance() {
        return distance;
    }

    public Time getTime() {
        return time;
    } 

    public Date getDate() {
        return date;
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public static List<Run> getAllRuns() {
        return allRuns;
    }

    @Override
    public String toString() {
        return String.format("Run{id='%s', distance=%.1f km, time=%s, date=%s, avarageSpeed=%.2f km/h pace=%.2f min/km, fitnessScore=%d}", 
        runId, distance.getDistance(), time, date, calcualteAverageSpeed(), calculatePace(), getCurrentScore());
    }

    public static double calculateTotalDistance() {
        double totalDistance = 0;
        for(Run run : allRuns) {
            totalDistance += run.distance.getDistance();
        }
        return totalDistance;
    }

    public static double calculateAverageDistance() {
        if(allRuns.isEmpty()) {
            return 0;
        }
        double totalDistance = allRuns.stream()
            .mapToDouble(run -> run.distance.getDistance())
            .sum();
            
            return totalDistance / allRuns.size();

    }

    public static Optional<Run> findRunById(String runId) {
        for(Run run : allRuns) {
            if(run.getRunId().equals(runId)) {
                return Optional.of(run);
            }
        }
        return Optional.empty();
    }

    public static boolean deleteRunById(String runId) {
        Optional<Run> runOptional = findRunById(runId);
        if(runOptional.isPresent()) {
            Run run = runOptional.get();
            allRuns.remove(run);
            System.out.println("Löprundan med ID-nummer " + runId + " har tagits bort.");
            return true;
        } else {
            System.out.println("Kunde inte hitta en  löprunda med ID-nummer "  + runId);
            return false;
        }

    }

    public static void clearExistingIds() {
        existingIds.clear();
    }

    public static void resetState() {
        currentScore = 0;
        lastRunDate = null;
        existingIds.clear();
    }
    
}
