package com.ww.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.dto.FlightDetailDto;
import com.ww.dto.FlightDto;
import com.ww.entity.FlightEntity;
import com.ww.repository.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDto> getFilghtInfoByDepartureAndDestinationAndDate(String departureAirportName,
                                                                         String destinationAirportName,
                                                                         java.sql.Date departureDate) {

        List<FlightEntity> listFlightEntity = flightRepository.findByDepartureAndDestinationAndDate(departureAirportName, destinationAirportName, departureDate);
        //        List<FlightDto> listFlightDto = listFlightEntity.stream()
        //                .map(FlightEntity ->
        //                        new FlightDto(
        //                                FlightEntity.getFlightNumber(),
        //                                FlightEntity.getDepartureAirport(),
        //                                FlightEntity.getDestinationAirport(),
        //                                FlightEntity.getDepartureDate(),
        //                                FlightEntity.getDepartureTime(),
        //                                FlightEntity.getPrice()
        //                        )
        //                )
        //                .collect(Collectors.toList());
        List<FlightDto> listFlightDto = new ArrayList<FlightDto>();
        listFlightDto = listFlightEntity.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return listFlightDto;
    }

    private FlightDto convertToDto(FlightEntity entity) {
        FlightDto flightDto = new FlightDto();
        BeanUtils.copyProperties(entity, flightDto);
        return flightDto;
    }

    public FlightDetailDto getFilghtInfoById(String flightNumber) {
        FlightEntity flightEntity = flightRepository.findByFlightNumber(flightNumber);
        FlightDetailDto flightDetailDto = new FlightDetailDto();
        flightDetailDto = new FlightDetailDto(
                flightEntity.getFlightNumber(),
                flightEntity.getDepartureAirport(),
                flightEntity.getDestinationAirport(),
                flightEntity.getDepartureDate(),
                flightEntity.getDepartureTime(),
                flightEntity.getPrice()
        );
        return flightDetailDto;
    }
}
