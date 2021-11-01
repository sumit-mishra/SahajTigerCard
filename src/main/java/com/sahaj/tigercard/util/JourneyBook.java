package com.sahaj.tigercard.util;

import com.sahaj.tigercard.constants.FareCap;
import com.sahaj.tigercard.exception.InvalidDateTimeException;
import com.sahaj.tigercard.journey.Journey;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JourneyBook {
    static Logger logger = Logger.getLogger(JourneyBook.class.getName());

    private static final String COLON = ":";

    public static LocalTime getTime(String date_time) {
        int hour = 0, minute = 0;
        try {
            String time = readTime(date_time);
            String[] hourAndMinute = time.split(COLON);
            hour = Integer.valueOf(hourAndMinute[0]);
            minute = Integer.valueOf(hourAndMinute[1]);
        } catch (Exception ex){
            logger.log(Level.SEVERE, "Couldn't read given date-time : "+ex.getMessage());
        }
        return LocalTime.of(hour, minute);
    }

    public static DayOfWeek getDay(String date_time) {
        return getDate(date_time).getDayOfWeek();
    }

    public static LocalDate getDate(String date_time) {
        String date = readDate(date_time);
        return LocalDate.parse(date);
    }

    public static boolean canWeeklyCapStartToday(LocalDate date) {
        DayOfWeek today = date.getDayOfWeek();
        return today.equals(DayOfWeek.MONDAY);
    }

    public static int getDailyCap(List<Journey> journeys) {
        int dailyCap = 0;
        if (journeys.stream().allMatch(Journey::isSameZone)) {
            if (journeys.get(0).getFromZone() == 1) {
                dailyCap = FareCap.ZONE1.daily;
            } else {
                dailyCap = FareCap.ZONE2.daily;
            }
        } else {
            dailyCap = FareCap.CROSSZONE.daily;
        }
        return dailyCap;
    }

    public static int getWeeklyCap(List<Journey> journeys) {
        int dailyCap = 0;
        if (journeys.stream().allMatch(Journey::isSameZone)) {
            if (journeys.get(0).getFromZone() == 1) {
                dailyCap = FareCap.ZONE1.weekly;
            } else {
                dailyCap = FareCap.ZONE2.weekly;
            }
        } else {
            dailyCap = FareCap.CROSSZONE.weekly;
        }
        return dailyCap;
    }

    private static String readTime(String date_time) {
        return date_time.substring(date_time.lastIndexOf("-") + 1);
    }

    private static String readDate(String date_time) {
        return date_time.substring(0, date_time.lastIndexOf("-"));
    }
}
