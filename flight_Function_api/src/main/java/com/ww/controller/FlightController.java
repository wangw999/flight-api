package com.ww.controller;

import com.ww.config.http.ResponseMessage;
import com.ww.dto.FlightDto;
import com.ww.dto.LoginRequestDto;
import com.ww.dto.LoginResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @GetMapping
    public List<FlightDto> flights(@RequestBody LoginRequestDto loginRequestDto) {
//        ResponseMessage<List<FlightDto>> response = ResponseMessage.success(serviceTypeService.getAllServiceTypes());
//        ResponseMessage<List<FlightDto>> response = null;
//        return ResponseEntity.status(HttpStatus.OK).body(response);
        return null;
    }
}
