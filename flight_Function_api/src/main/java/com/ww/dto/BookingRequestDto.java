package com.ww.dto;

import com.ww.entity.PassengerEntity;

public class BookingRequestDto {

    private Long flightId;

    private PassengerEntity PassengerInfo;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public PassengerEntity getPassengerInfo() {
        return PassengerInfo;
    }

    public void setPassengerInfo(PassengerEntity passengerInfo) {
        PassengerInfo = passengerInfo;
    }
}
