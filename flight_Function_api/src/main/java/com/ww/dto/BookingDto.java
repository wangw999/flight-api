package com.ww.dto;

import com.ww.entity.FlightEntity;

import java.time.LocalDateTime;

public class BookingDto {

    private FlightEntity flight;

    private String reference;

    private String status;

    private LocalDateTime bookingTime;

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

}
