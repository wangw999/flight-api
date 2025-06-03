package com.ww.repository;

import com.ww.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    // 根据机场代码查找机场
    Optional<Airport> findByCode(String code);
}