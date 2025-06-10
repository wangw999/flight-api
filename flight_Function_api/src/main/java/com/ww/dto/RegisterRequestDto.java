package com.ww.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String phone;
}
