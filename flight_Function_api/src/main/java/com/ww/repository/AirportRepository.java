package com.ww.repository;

import com.ww.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
    // 根据机场代码查找机场
    Optional<AirportEntity> findByCode(String code);
}