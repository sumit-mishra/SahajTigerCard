package com.sahaj.tigercard.constants;

import java.time.LocalTime;

public class Timing {
    LocalTime fromTime;
    LocalTime toTime;

    public Timing(LocalTime fromTime, LocalTime toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }
}
