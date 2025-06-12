package com.ww.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ww.config.http.ResponseMessage;
import com.ww.dto.BookingDetailDto;
import com.ww.dto.BookingDto;
import com.ww.dto.BookingRequestDto;
import com.ww.service.BookingsService;

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
    // @RequestParam(name = "status") int status,
    // @RequestParam(name = "page", defaultValue = "1") int page,
    // @RequestParam(name = "size", defaultValue = "10") int size) {
    ) {
        // List<BookingDto> bookings = bookingsService.getBookings(page, size);
        List<BookingDto> bookings = bookingsService.getBookings();
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
        BookingDto booking = bookingsService.createBooking(bookingRequestInfo.getFlightNumber(),
                bookingRequestInfo.getPassengerInfo());
        ResponseMessage<BookingDto> response = ResponseMessage.success(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
