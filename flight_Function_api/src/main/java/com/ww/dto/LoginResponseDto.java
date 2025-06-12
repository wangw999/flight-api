package com.ww.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    
    private String email;
    private String token;
    
    public LoginResponseDto(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
