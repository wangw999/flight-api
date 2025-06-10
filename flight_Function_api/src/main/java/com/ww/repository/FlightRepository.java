package com.ww.repository;

import com.ww.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
        // 根据航班号查找航班
        FlightEntity findByFlightNumber(String flightNumber);

        // 根据出发机场ID查找航班列表
        List<FlightEntity> findByDepartureAirportAirportId(Long departureAirportId);

        // 根据到达机场ID查找航班列表
        List<FlightEntity> findByDestinationAirportAirportId(Long destinationAirportId);

        @Query("SELECT f FROM FlightEntity f " +
                        "WHERE f.departureAirport.name = :from " +
                        "AND f.destinationAirport.name = :to " +
                        "AND f.departureDate = :date")
        List<FlightEntity> findByDepartureAndDestinationAndDate(
                        @Param("from") String departureAirportName,
                        @Param("to") String destinationAirportName,
                        @Param("date") java.sql.Date departureDate);

        @Query("SELECT f FROM FlightEntity f " +
                        "WHERE f.departureAirport.city = :from " +
                        "AND f.destinationAirport.city = :to " +
                        "AND f.departureDate = :date")
        List<FlightEntity> findByDepartureCityAndDestinationCityAndDate(
                        @Param("from") String departureAirportCity,
                        @Param("to") String destinationAirportCity,
                        @Param("date") java.sql.Date departureDate);
}