package com.ww.dto;

import com.ww.entity.PassengerEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDto {

    private String flightId;

    private PassengerEntity passengerInfo;
}
