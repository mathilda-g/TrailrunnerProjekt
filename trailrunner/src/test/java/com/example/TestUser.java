package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestUser {

    private User user;
    private Distance distance;
    private Time time;
    private Date date;

    @BeforeEach
    public void setUp() {
        distance = new Distance(5.5);
        time = new Time(01, 30, 15);
        date = new Date("2025-01-10");

        user = new User("Mathilda", distance, time, date, 165,58, 26);

    }
    @Test
    public void shouldCreateUserCorrectly() {
        
        Assertions.assertNotNull(user);
        Assertions.assertEquals("Mathilda", user.getName());
        Assertions.assertEquals(165, user.getLength());
        Assertions.assertEquals(58, user.getWeight());
        Assertions.assertEquals(26, user.getAge());
        Assertions.assertEquals(distance, user.getDistance());
        Assertions.assertEquals(time, user.getTime());
        Assertions.assertEquals(date, user.getDate());

    }

    @Test
    public void updateUsersAttributesCorrectly() {
        user.setName("Hailey");
        user.setHeight(115.0);
        user.setWeight(15.0);
        user.setAge(5);
        user.setDistance(new Distance(6.0));
        user.setTime(new Time(0,30, 0));
        user.setDate(new Date("2025-01-11"));

        Assertions.assertEquals("Hailey", user.getName());
        Assertions.assertEquals(115.0, user.getLength());
        Assertions.assertEquals(15.0, user.getWeight());
        Assertions.assertEquals(5, user.getAge());
        Assertions.assertEquals(6.0, user.getDistance().getDistance());
        Assertions.assertEquals("00:30:00", user.getTime().toString());
        Assertions.assertEquals("2025-01-11", user.getDate().toString());

    }

    @Test
    public void testToString() {

        String expectedString = "User{name='Hailey', height=115.0, weight=15.0, age=5, distance=6.0, time=00:30:00, date=2025-01-11}";
        Assertions.assertEquals(expectedString, user.toString());

    }


    
}
