package com.sahaj.tigercard.model;

public class Ticket {

    private String zone;
    private int calculatedFare;

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getCalculatedFare() {
        return calculatedFare;
    }

    public void setCalculatedFare(int calculatedFare) {
        this.calculatedFare = calculatedFare;
    }
}
