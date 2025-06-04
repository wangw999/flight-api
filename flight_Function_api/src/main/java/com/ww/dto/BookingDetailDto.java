package com.ww.dto;

import com.ww.entity.FlightEntity;
import com.ww.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookingDetailDto {

    private UserEntity user;

    private FlightEntity flight;

    private String reference;

    private String status;

    private LocalDateTime bookingTime;

    private BigDecimal totalPrice;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
