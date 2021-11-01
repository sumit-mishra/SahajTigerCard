package com.sahaj.tigercard.fare;

import com.sahaj.tigercard.journey.Journey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FareCapCalculatorTest {

    @Test
    public void shouldReturn120ForMultiJourneyDailyCap_whenAllTheJourneysAreOnSameDay() {
        List<Journey> journeys = new ArrayList<>();
        Journey journey1 = new Journey("2021-10-25-10:20", 2, 1);
        journeys.add(journey1);

        Journey journey2 = new Journey("2021-10-25-10:45", 1, 1);
        journeys.add(journey2);

        Journey journey3 = new Journey("2021-10-25-16:15", 1, 1);
        journeys.add(journey3);

        Journey journey4 = new Journey("2021-10-25-18:15", 1, 1);
        journeys.add(journey4);

        Journey journey5 = new Journey("2021-10-25-19:00", 1, 2);
        journeys.add(journey5);

        FareCapCalculator fareCapCalculator = new FareCapCalculator(journeys);
        Assertions.assertEquals(120, fareCapCalculator.getTotalFare());
    }

    @Test
    public void shouldReturn45ForMultiJourneyOffPeakHours_whenTheJourneysAreOnDifferentDays() {
        List<Journey> journeys = new ArrayList<>();
        Journey journey1 = new Journey("2021-10-25-10:00", 1, 1);
        journeys.add(journey1);

        Journey journey2 = new Journey("2021-10-26-11:00", 2, 2);
        journeys.add(journey2);

        FareCapCalculator fareCapCalculator = new FareCapCalculator(journeys);
        Assertions.assertEquals(50, fareCapCalculator.getTotalFare());
    }

    @Test
    public void shouldReturn720ForMultiJourneyWeeklyCap_whenJourneysAcrossWeek() {
        List<Journey> journeys = new ArrayList<>();
        Journey journey0 = new Journey("2021-10-24-10:20", 2, 1);
        journeys.add(journey0);

        //DAY 1
        Journey journey1 = new Journey("2021-10-25-10:20", 2, 1);
        journeys.add(journey1);

        Journey journey2 = new Journey("2021-10-25-10:45", 1, 1);
        journeys.add(journey2);

        Journey journey3 = new Journey("2021-10-25-16:15", 1, 1);
        journeys.add(journey3);

        Journey journey4 = new Journey("2021-10-25-18:15", 1, 1);
        journeys.add(journey4);

        Journey journey5 = new Journey("2021-10-25-19:00", 1, 2);
        journeys.add(journey5);

        //DAY 2
        Journey journey6 = new Journey("2021-10-26-10:20", 2, 1);
        journeys.add(journey6);

        Journey journey7 = new Journey("2021-10-26-10:45", 1, 1);
        journeys.add(journey7);

        Journey journey8 = new Journey("2021-10-26-16:15", 1, 1);
        journeys.add(journey8);

        Journey journey9 = new Journey("2021-10-26-18:15", 1, 1);
        journeys.add(journey9);

        Journey journey10 = new Journey("2021-10-26-19:00", 1, 2);
        journeys.add(journey10);

        //DAY 3
        Journey journey11 = new Journey("2021-10-27-10:20", 2, 1);
        journeys.add(journey11);

        Journey journey12 = new Journey("2021-10-27-10:45", 1, 1);
        journeys.add(journey12);

        Journey journey13 = new Journey("2021-10-27-16:15", 1, 1);
        journeys.add(journey13);

        Journey journey14 = new Journey("2021-10-27-18:15", 1, 1);
        journeys.add(journey14);

        Journey journey15 = new Journey("2021-10-27-19:00", 1, 2);
        journeys.add(journey15);

        //DAY 4
        Journey journey16 = new Journey("2021-10-28-10:20", 2, 1);
        journeys.add(journey16);

        Journey journey17 = new Journey("2021-10-28-10:45", 1, 1);
        journeys.add(journey17);

        Journey journey18 = new Journey("2021-10-28-16:15", 1, 1);
        journeys.add(journey18);

        Journey journey19 = new Journey("2021-10-28-18:15", 1, 1);
        journeys.add(journey19);

        Journey journey20 = new Journey("2021-10-28-19:00", 1, 2);
        journeys.add(journey20);

        //DAY 5
        Journey journey21 = new Journey("2021-10-29-10:20", 2, 1);
        journeys.add(journey21);

        Journey journey22 = new Journey("2021-10-29-10:45", 1, 1);
        journeys.add(journey22);

        Journey journey23 = new Journey("2021-10-29-16:15", 1, 1);
        journeys.add(journey23);

        Journey journey24 = new Journey("2021-10-29-18:15", 1, 1);
        journeys.add(journey24);

        Journey journey25 = new Journey("2021-10-29-19:00", 1, 2);
        journeys.add(journey25);

        //DAY 6
        Journey journey26 = new Journey("2021-10-30-10:20", 2, 1);
        journeys.add(journey26);

        Journey journey27 = new Journey("2021-10-30-10:45", 1, 1);
        journeys.add(journey27);

        Journey journey28 = new Journey("2021-10-30-16:15", 1, 1);
        journeys.add(journey28);

        Journey journey29 = new Journey("2021-10-30-18:15", 1, 1);
        journeys.add(journey29);

        Journey journey30 = new Journey("2021-10-30-19:00", 1, 2);
        journeys.add(journey30);

        //DAY 7
        Journey journey31 = new Journey("2021-10-31-10:20", 2, 1);
        journeys.add(journey31);

        Journey journey32 = new Journey("2021-10-31-10:45", 1, 1);
        journeys.add(journey32);

        Journey journey33 = new Journey("2021-10-31-16:15", 1, 1);
        journeys.add(journey33);

        Journey journey34 = new Journey("2021-10-31-18:15", 1, 1);
        journeys.add(journey34);

        Journey journey35 = new Journey("2021-10-31-19:00", 1, 2);
        journeys.add(journey35);

        //DAY 8
        Journey journey36 = new Journey("2021-11-01-10:20", 2, 1);
        journeys.add(journey36);

        Journey journey37 = new Journey("2021-11-01-10:45", 1, 1);
        journeys.add(journey37);

        Journey journey38 = new Journey("2021-11-01-16:15", 1, 1);
        journeys.add(journey38);

        FareCapCalculator fareCapCalculator = new FareCapCalculator(journeys);
        Assertions.assertEquals(720, fareCapCalculator.getTotalFare());
    }

}
