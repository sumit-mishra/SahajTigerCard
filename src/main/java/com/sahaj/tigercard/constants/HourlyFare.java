package com.sahaj.tigercard.constants;

public enum HourlyFare {
    ZONE1(30, 25),
    ZONE2(25, 20),
    CROSSZONE(35, 30);

    public final int peakHourFare;
    public final int offPeakHourFare;

    private HourlyFare(int peakHourFare, int offPeakHourFare) {
        this.peakHourFare = peakHourFare;
        this.offPeakHourFare = offPeakHourFare;
    }
}
