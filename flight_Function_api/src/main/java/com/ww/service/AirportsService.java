package com.ww.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.dto.AirportDto;
import com.ww.entity.AirportEntity;
import com.ww.repository.AirportRepository;

@Service
public class AirportsService {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportsService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportDto> getAirports() {
        return airportRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AirportDto mapToDTO(AirportEntity entity) {
        AirportDto dto = new AirportDto();
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setCity(entity.getCity());
        return dto;
    }
}
