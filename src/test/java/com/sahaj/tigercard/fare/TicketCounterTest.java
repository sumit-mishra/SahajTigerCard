package com.sahaj.tigercard.fare;

import com.sahaj.tigercard.journey.Journey;
import com.sahaj.tigercard.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketCounterTest {

    private Journey journey;

    @BeforeEach
    public void setup() {
        journey = new Journey();
        journey.setDate_time("2021-10-30-10:20");
        journey.setFromZone(2);
        journey.setToZone(1);
    }

    @Test
    public void shouldReturn35_forDefaultSetupDateTime() {
        TicketCounter calculator = new TicketCounter();
        Ticket ticket = calculator.getTicket(journey);
        Assertions.assertEquals(35,ticket.getCalculatedFare());
    }
}
