package com.sahaj.tigercard.journey;

public class Journey {
    private String date_time;
    private int fromZone;
    private int toZone;

    public Journey() {
    }

    public Journey(String date_time, int fromZone, int toZone) {
        this.date_time = date_time;
        this.fromZone = fromZone;
        this.toZone = toZone;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getFromZone() {
        return fromZone;
    }

    public void setFromZone(int fromZone) {
        this.fromZone = fromZone;
    }

    public int getToZone() {
        return toZone;
    }

    public void setToZone(int toZone) {
        this.toZone = toZone;
    }

    public boolean isSameZone() {
        return fromZone == toZone;
    }
}
