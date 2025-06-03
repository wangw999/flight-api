package com.ww.dto;

import com.ww.entity.AirportEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class FlightDetailDto {
    private String flightNumber;

    private AirportEntity departureAirport;

    private AirportEntity destinationAirport;

    private Date departureDate;

    private Time departureTime;

    private BigDecimal price;

    public FlightDetailDto(String flightNumber, AirportEntity departureAirport, AirportEntity destinationAirport, Date departureDate, Time departureTime, BigDecimal price) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.price = price;
    }

    public FlightDetailDto() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public AirportEntity getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(AirportEntity destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public AirportEntity getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportEntity departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
