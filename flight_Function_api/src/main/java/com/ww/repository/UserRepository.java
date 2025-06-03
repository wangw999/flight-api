package com.ww.repository;

import com.ww.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 根据邮箱查找用户
    Optional<User> findByEmail(String email);
}