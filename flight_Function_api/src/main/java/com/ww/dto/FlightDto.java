package com.ww.dto;

import com.ww.entity.AirportEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class FlightDto {

    private String flightNumber;

    private AirportEntity departureAirport;

    private AirportEntity destinationAirport;

    private Date departureDate;

    private Time departureTime;

    private BigDecimal price;

    public FlightDto(String flightNumber, AirportEntity departureAirport, AirportEntity destinationAirport, Date departureDate, Time departureTime, BigDecimal price) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.price = price;
    }
    public FlightDto() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public AirportEntity getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportEntity departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportEntity getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(AirportEntity destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
