package com.sahaj.tigercard.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class JourneyBookTest {

    private String date_time;

    @BeforeEach
    public void setup() {
        date_time = "2021-10-30-10:20";
    }

    @Test
    public void whenDateTimeIsPassed_thenReturnDayOfWeek() {
        DayOfWeek day = JourneyBook.getDay(date_time);
        Assertions.assertEquals(DayOfWeek.SATURDAY, day);
    }

    @Test
    public void whenDateTimeIsPassed_thenReturnLocalTime() {
        LocalTime time = JourneyBook.getTime(date_time);
        Assertions.assertEquals(LocalTime.of(10, 20), time);
    }
}
