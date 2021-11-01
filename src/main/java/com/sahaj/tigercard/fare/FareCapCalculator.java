package com.sahaj.tigercard.fare;

import com.sahaj.tigercard.journey.Journey;
import com.sahaj.tigercard.model.Ticket;
import com.sahaj.tigercard.util.JourneyBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class FareCapCalculator {

    private final TicketCounter ticketCounter;
    private final List<Journey> journeys;

    private final int dailyCap;
    private final int weeklyCap;

    private int totalDailyFare;
    private LocalDate journeyDate;
    private boolean isDailyCapApplicable;

    private boolean isNewWeek;
    private int totalWeeklyFare;
    private LocalDate weekStartDate;

    public FareCapCalculator(List<Journey> journeys) {
        ticketCounter = new TicketCounter();
        this.journeys = journeys;
        this.dailyCap = JourneyBook.getDailyCap(journeys);
        this.weeklyCap = JourneyBook.getWeeklyCap(journeys);
    }

    public int getTotalFare() {
        List<Ticket> tickets = getTickets(journeys);
        return tickets.stream().mapToInt(Ticket::getCalculatedFare).sum();
    }

    private List<Ticket> getTickets(List<Journey> journeys) {
        List<Ticket> tickets = new ArrayList<>();
        journeyDate = getStartDate(journeys.get(0));
        for (Journey journey : journeys) {
            LocalDate todayDate = JourneyBook.getDate(journey.getDate_time());
            Ticket ticket = ticketCounter.getTicket(journey);
            checkForDailyFare(todayDate, ticket);
            checkForWeeklyFare(todayDate, ticket);
            tickets.add(ticket);
        }
        return tickets;
    }

    private void checkForDailyFare(LocalDate todayDate, Ticket ticket) {
        if (journeyDate.isEqual(todayDate)) {
            resetDay(totalDailyFare + ticket.getCalculatedFare(), true);
        } else {
            resetDay(ticket.getCalculatedFare(), false);
        }
        updateTotalDailyFare(totalDailyFare, ticket);
    }

    private void checkForWeeklyFare(LocalDate todayDate, Ticket ticket) {
        if (JourneyBook.canWeeklyCapStartToday(todayDate) && !isNewWeek) {
            resetWeek(todayDate);
            totalWeeklyFare = ticket.getCalculatedFare();
        } else {
            totalWeeklyFare += ticket.getCalculatedFare();
        }
        if (shouldEvaluateWeeklyFare(todayDate)) {
            if (DAYS.between(weekStartDate, todayDate) > 0) {
                isNewWeek = false;
            }
            updateTotalWeeklyFare(totalWeeklyFare, ticket);
        }
    }

    private boolean shouldEvaluateWeeklyFare(LocalDate todayDate) {
        return weekStartDate != null
                && DAYS.between(weekStartDate, todayDate) < 7
                && totalWeeklyFare > weeklyCap;
    }

    private void updateTotalWeeklyFare(int totalWeeklyFare, Ticket ticket) {
        int cappedFare = weeklyCap - totalWeeklyFare;
        if (cappedFare < 0) {
            ticket.setCalculatedFare(0);
        } else {
            ticket.setCalculatedFare(cappedFare);
        }
    }

    private void updateTotalDailyFare(int totalDailyFare, Ticket ticket) {
        if (isDailyCapApplicable && totalDailyFare > dailyCap) {
            totalDailyFare = totalDailyFare - ticket.getCalculatedFare();
            int cappedFare = dailyCap - totalDailyFare;
            ticket.setCalculatedFare(cappedFare);
        }
    }

    private LocalDate getStartDate(Journey journey) {
        return JourneyBook.getDate(journey.getDate_time());
    }

    private void resetWeek(LocalDate weekStartDate) {
        this.isNewWeek = true;
        this.totalWeeklyFare = 0;
        this.weekStartDate = weekStartDate;
    }

    private void resetDay(int dailyFare, boolean isDailyCapApplicable) {
        this.totalDailyFare = dailyFare;
        this.isDailyCapApplicable = isDailyCapApplicable;
    }

}
