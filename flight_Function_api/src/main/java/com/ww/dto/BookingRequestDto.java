package com.ww.dto;

import com.ww.entity.PassengerEntity;

public class BookingRequestDto {

    private String flightId;

    private PassengerEntity PassengerInfo;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public PassengerEntity getPassengerInfo() {
        return PassengerInfo;
    }

    public void setPassengerInfo(PassengerEntity passengerInfo) {
        PassengerInfo = passengerInfo;
    }
}
