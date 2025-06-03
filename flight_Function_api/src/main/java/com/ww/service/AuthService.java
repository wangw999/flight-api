package com.ww.service;

import com.ww.entity.UserEntity;
import com.ww.dto.LoginRequestDto;
import com.ww.dto.LoginResponseDto;
import com.ww.dto.RegisterRequestDto;
import com.ww.exception.ResourceNotFoundException;
import com.ww.config.jwt.JwtUtil;
import com.ww.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        UserEntity user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponseDto(token);
    }

    public boolean register(RegisterRequestDto registerRequestDto) {
        UserEntity user = new UserEntity();
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
//        user.setUserName(registerRequestDto.getEmail());
//        user.setFullName(registerRequestDto.getFullName());
//        user.setRole(User.Role.CUSTOMER);

        userRepository.save(user);
        return true;
    }
}
