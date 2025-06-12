package com.ww.dto;

import com.ww.entity.FlightEntity;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {

    private Long bookingId;

    private FlightEntity flight;

    private String reference;

    private String status;

    private LocalDateTime bookingTime;

}
