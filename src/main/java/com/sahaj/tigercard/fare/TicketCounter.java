package com.sahaj.tigercard.fare;

import com.sahaj.tigercard.constants.HourlyFare;
import com.sahaj.tigercard.constants.PeakHours;
import com.sahaj.tigercard.constants.Timing;
import com.sahaj.tigercard.journey.Journey;
import com.sahaj.tigercard.model.Ticket;
import com.sahaj.tigercard.util.JourneyBook;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TicketCounter {

    public static final String ZONE_1 = "ZONE1";
    public static final String ZONE_2 = "ZONE2";
    public static final String CROSSZONE = "CROSSZONE";

    public Ticket getTicket(Journey journey) {
        int hourlyFare = 0;
        String zone = getZone(journey);
        Ticket ticket = new Ticket();

        switch (zone) {
            case ZONE_1:
                hourlyFare = getHourlyFare(journey.getDate_time(), ZONE_1);
                ticket.setZone(ZONE_1);
                break;
            case ZONE_2:
               hourlyFare =  getHourlyFare(journey.getDate_time(), ZONE_2);
                ticket.setZone(ZONE_2);
                break;
            case CROSSZONE:
                hourlyFare = getHourlyFare(journey.getDate_time(), CROSSZONE);
                ticket.setZone(CROSSZONE);
                break;
        }
        ticket.setCalculatedFare(hourlyFare);
        return ticket;
    }

    private String getZone(Journey journey) {
        String zone;
        if (journey.getFromZone() == 1 && journey.getToZone() == 1) {
            zone = ZONE_1;
        } else if (journey.getFromZone() == 2 && journey.getToZone() == 2) {
            zone = ZONE_2;
        } else if ((journey.getFromZone() == 1 && journey.getToZone() == 2)
                || (journey.getFromZone() == 2 && journey.getToZone() == 1)) {
            zone = CROSSZONE;
        } else {
            throw new IllegalArgumentException("Invalid zone information provided for the journey.");
        }
        return zone;
    }

    private int getHourlyFare(String date_time, String zone) {
        DayOfWeek day = JourneyBook.getDay(date_time);
        LocalTime journeyTime = JourneyBook.getTime(date_time);
        int fare = 0;
        switch (day) {
            case MONDAY:

            case TUESDAY:

            case WEDNESDAY:

            case THURSDAY:

            case FRIDAY:
                fare = getFare(journeyTime, PeakHours.WEEKDAY, zone);
                break;

            case SATURDAY:

            case SUNDAY:
                fare = getFare(journeyTime, PeakHours.WEEKEND, zone);
                break;
        }
        return fare;
    }

    private int getFare(LocalTime journeyTime, Enum day, String zone) {
        int fare = HourlyFare.valueOf(zone).offPeakHourFare;;
        if (day.equals(PeakHours.WEEKEND)) {
            for (Timing peakTime : PeakHours.WEEKEND.getTimings()) {
                if (journeyTime.isAfter(peakTime.getFromTime()) && journeyTime.isBefore(peakTime.getToTime())) {
                    fare = HourlyFare.valueOf(zone).peakHourFare;
                }
            }
        } else if (day.equals(PeakHours.WEEKDAY)) {
            for (Timing peakTime : PeakHours.WEEKDAY.getTimings()) {
                if (journeyTime.isAfter(peakTime.getFromTime()) && journeyTime.isBefore(peakTime.getToTime())) {
                    fare = HourlyFare.valueOf(zone).peakHourFare;
                }
            }
        }
        return fare;
    }

}
