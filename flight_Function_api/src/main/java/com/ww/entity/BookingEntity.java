package com.ww.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "BOOKING")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private String status;

    private LocalDateTime bookingTime;

    private BigDecimal totalPrice;

}
