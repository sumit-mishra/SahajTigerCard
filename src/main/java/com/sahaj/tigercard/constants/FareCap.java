package com.sahaj.tigercard.constants;

public enum FareCap {
    ZONE1(100, 500),
    ZONE2(80, 400),
    CROSSZONE(120, 600);

    public final int daily;
    public final int weekly;

    private FareCap(int daily, int weekly) {
        this.daily = daily;
        this.weekly = weekly;
    }
}
