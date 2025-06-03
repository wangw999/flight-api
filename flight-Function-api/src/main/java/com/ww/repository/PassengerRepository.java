package com.ww.repository;

import com.ww.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // 根据邮箱查找乘客
    Optional<Passenger> findByEmail(String email);
}