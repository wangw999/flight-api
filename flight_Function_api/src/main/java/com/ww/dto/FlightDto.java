package com.ww.dto;

import com.ww.entity.AirportEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class FlightDto {

    private Long flightId;

    private String flightNumber;

    private AirportEntity departureAirport;

    private AirportEntity destinationAirport;

    private Date departureDate;

    private Time departureTime;

    private BigDecimal price;
}
