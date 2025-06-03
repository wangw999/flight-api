package com.ww.repository;

import com.ww.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
    // 根据航班号查找航班
    Optional<FlightEntity> findByFlightNumber(String flightNumber);
    // 根据出发机场ID查找航班列表
    List<FlightEntity> findByDepartureAirportAirportId(Long departureAirportId);
    // 根据到达机场ID查找航班列表
    List<FlightEntity> findByDestinationAirportAirportId(Long destinationAirportId);
}