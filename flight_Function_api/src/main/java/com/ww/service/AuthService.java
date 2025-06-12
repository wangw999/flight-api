package com.ww.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ww.config.jwt.JwtUtil;
import com.ww.dto.LoginRequestDto;
import com.ww.dto.LoginResponseDto;
import com.ww.dto.RegisterRequestDto;
import com.ww.entity.UserEntity;
import com.ww.exception.ResourceNotFoundException;
import com.ww.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        UserEntity user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Password is Wrong！");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponseDto(user.getEmail(),token);
    }

    public boolean register(RegisterRequestDto registerRequestDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(registerRequestDto, userEntity);
        userEntity.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

        userRepository.save(userEntity);
        return true;
    }
}
