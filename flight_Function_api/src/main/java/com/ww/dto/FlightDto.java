package com.ww.dto;

import com.ww.entity.AirportEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
