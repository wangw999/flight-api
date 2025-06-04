package com.ww.controller;

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
    public ResponseEntity<List<BookingDto>> getBookings(
            @RequestParam(name = "status") int status,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        List<BookingDto> bookings = bookingsService.getBookings(page, size);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDetailDto> getBookingById(
            @PathVariable("id") Long id) {
        BookingDetailDto booking = bookingsService.getBookingById(id);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(
            @RequestBody BookingRequestDto bookingRequestInfo) {
        BookingDto booking = bookingsService.createBooking(bookingRequestInfo.getFlightId(), bookingRequestInfo.getPassengerInfo());
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
