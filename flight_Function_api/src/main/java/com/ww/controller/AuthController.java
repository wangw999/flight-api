package com.ww.controller;

import com.ww.dto.LoginRequestDto;
import com.ww.dto.LoginResponseDto;
import com.ww.dto.RegisterRequestDto;
import com.ww.config.http.ResponseMessage;
import com.ww.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseMessage<LoginResponseDto>> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = authService.login(loginRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseMessage.success(loginResponseDto));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage<String>> register(@RequestBody RegisterRequestDto registerRequestDto) {
        boolean result = authService.register(registerRequestDto);
        if (result) {
            ResponseMessage<String> message = ResponseMessage.success("Register success");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseMessage.error(400, "Register failed"));
    }
}
