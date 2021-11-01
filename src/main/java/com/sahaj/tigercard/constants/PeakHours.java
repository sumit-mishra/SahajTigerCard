package com.sahaj.tigercard.constants;

import com.sahaj.tigercard.util.JourneyBook;

import java.util.List;

public enum PeakHours {
    WEEKDAY(new Timing(JourneyBook.getTime("07:30"), JourneyBook.getTime("10:30")),
            new Timing(JourneyBook.getTime("17:30"), JourneyBook.getTime("20:00"))),
    
    WEEKEND(new Timing(JourneyBook.getTime("09:00"), JourneyBook.getTime("11:00")),
            new Timing(JourneyBook.getTime("18:00"), JourneyBook.getTime("22:00")));

    private final List<Timing> timings;

    private PeakHours(Timing... timings) {
        this.timings = List.of(timings);
    }

    public List<Timing> getTimings() {
        return timings;
    }

}
