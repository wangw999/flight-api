package com.ww.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ww.config.http.ResponseMessage;
import com.ww.dto.FlightDetailDto;
import com.ww.dto.FlightDto;
import com.ww.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<List<FlightDto>>> getFlightsByDepartureAndDestinationAndDate(@RequestParam("from") String from,
                                                                       @RequestParam("to") String to,
                                                                       @RequestParam("date")@DateTimeFormat(pattern = "yyyyMMdd") LocalDate date ) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        List<FlightDto> flights = flightService.getFilghtInfoByCityAndDate(from, to, sqlDate);
        ResponseMessage<List<FlightDto>> response = ResponseMessage.success(flights);
        return ResponseEntity.status(HttpStatus.OK)  // 设置 HTTP 状态码为 200
                .body(response);                     // 设置响应体为封装好的 ResponseMessage
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<FlightDetailDto>> getFlightsInfoById(@PathVariable("id") String flightNumber) {
        FlightDetailDto flightDetail = flightService.getFlightInfoById(flightNumber);
        ResponseMessage<FlightDetailDto> response = ResponseMessage.success(flightDetail);
        return ResponseEntity.status(HttpStatus.OK)  // 设置 HTTP 状态码为 200
                .body(response);                     // 设置响应体为封装好的 ResponseMessage
    }
}
