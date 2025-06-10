package com.ww.controller;

import com.ww.config.http.ResponseMessage;
import com.ww.dto.BookingDetailDto;
import com.ww.dto.BookingDto;
import com.ww.dto.BookingRequestDto;
import com.ww.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingsService bookingsService;

    @Autowired
    public BookingController(BookingsService bookingService) {
        this.bookingsService = bookingService;
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<List<BookingDto>>> getBookings(
            @RequestParam(name = "status") int status,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        List<BookingDto> bookings = bookingsService.getBookings(page, size);
        ResponseMessage<List<BookingDto>> response = ResponseMessage.success(bookings);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<BookingDetailDto>> getBookingById(
            @PathVariable("id") Long id) {
        BookingDetailDto booking = bookingsService.getBookingById(id);
        ResponseMessage<BookingDetailDto> response = ResponseMessage.success(booking);
        if (booking != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage<BookingDto>> createBooking(
            @RequestBody BookingRequestDto bookingRequestInfo) {
        BookingDto booking = bookingsService.createBooking(bookingRequestInfo.getFlightId(), bookingRequestInfo.getPassengerInfo());
        ResponseMessage<BookingDto> response = ResponseMessage.success(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
