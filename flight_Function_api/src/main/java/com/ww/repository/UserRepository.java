package com.ww.repository;

import com.ww.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // 根据邮箱查找用户
    Optional<UserEntity> findByEmail(String email);
}