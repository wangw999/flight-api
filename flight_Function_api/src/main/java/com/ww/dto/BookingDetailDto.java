package com.ww.dto;

import com.ww.entity.FlightEntity;
import com.ww.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDetailDto {

    private UserEntity user;

    private FlightEntity flight;

    private String reference;

    private String status;

    private LocalDateTime bookingTime;

    private BigDecimal totalPrice;

 }
