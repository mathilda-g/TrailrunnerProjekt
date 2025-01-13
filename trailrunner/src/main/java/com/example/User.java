package com.example;

public class User {

    private String name;
    private double height;
    private double weight;
    private int age;
    private Distance distance;
    private Time time;
    private Date date;
    

    public User(String name, Distance distance, Time time, Date date, double height, double weight, int age) {
        this.name = name;
        this.distance = distance;
        this.time = time;
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)  {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', height=%.1f cm, weight=%.1f kg, age=%d, distance=%s, time=%s, date=%s}",
        name, height, weight, age, distance, time, date);

    }







    
}
