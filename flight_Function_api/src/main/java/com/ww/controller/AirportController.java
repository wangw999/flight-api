package com.ww.controller;

import com.ww.dto.AirportDto;
import com.ww.service.AirportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportsService airportsService;

    // 修正构造函数参数名，与成员变量名保持一致
    public AirportController(AirportsService airportsService) {
        this.airportsService = airportsService;
    }

    // 修正返回类型的拼写错误
    @GetMapping
    public ResponseEntity<List<AirportDto>> getAirports() {
        List<AirportDto> response = airportsService.getAirports();
        return ResponseEntity.status(HttpStatus.OK)  // 设置 HTTP 状态码为 200
                .body(response);                     // 设置响应体为封装好的 ResponseMessage
    }
}
