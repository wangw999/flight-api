package com.ww.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "FLIGHT")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Column(nullable = false)
    private String flightNumber;

    // 出发机场
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private AirportEntity departureAirport;

    // 到达机场
    @ManyToOne
    @JoinColumn(name = "destination_airport_id")
    private AirportEntity destinationAirport;

    private Date departureDate;

    private Time departureTime;

    private Date destinationDate;

    private Time destinationTime;

    private BigDecimal price;
}
