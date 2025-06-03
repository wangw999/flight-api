package com.ww.repository;

import com.ww.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
    // 根据邮箱查找乘客
    Optional<PassengerEntity> findByEmail(String email);
}