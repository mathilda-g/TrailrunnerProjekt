package com.example;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Date {
    
    private String date;

    public Date(String date) {
        if(date == null || date.isEmpty()) {
            this.date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            this.date = date;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static String saveDate(String date) {
        if(date == null || date.isEmpty()) {
            LocalDate todaysLocalDate = LocalDate.now();
            return todaysLocalDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        return date;
    }

    @Override
    public String toString() {
        return date;
    }

}
