package com.ww.repository;

import com.ww.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    // 根据用户ID查找其所有预订记录
    List<BookingEntity> findByUserUserId(Long userId);
    // 根据预订ID查找预订记录
    Optional<BookingEntity> findByBookingId(Long bookingId);
}