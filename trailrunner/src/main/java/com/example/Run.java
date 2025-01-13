package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Run {

    private static final Set<String> existingIds = new HashSet<>();
    private final String runId;
    private final Distance distance;
    private final Time time;
    private final Date date;

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

    @Override
    public String toString() {
        return String.format("Run{id='%s', distance=%s, time=%s, date=%s}", runId, distance, time, date);
    }



}
