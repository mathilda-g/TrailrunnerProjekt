package com.example;

public class User {

    private String name;
    private double length;
    private double weight;
    private int age;
    private Distance distance;
    private Time time;
    private Date date;
    

    public User(String name, Distance distance, Time time, Date date, double length, double weight, int age) {
        this.name = name;
        this.distance = distance;
        this.time = time;
        this.date = date;
        this.length = length;
        this.weight = weight;
        this.age = age;
    }



    
}
