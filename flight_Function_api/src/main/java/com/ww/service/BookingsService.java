package com.ww.service;

import com.ww.dto.BookingDetailDto;
import com.ww.dto.BookingDto;
import com.ww.entity.BookingEntity;
import com.ww.entity.FlightEntity;
import com.ww.entity.PassengerEntity;
import com.ww.repository.BookingRepository;
import com.ww.repository.FlightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingsService {
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public BookingsService(BookingRepository bookingRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }

    // public List<BookingDto> getBookings(int page, int size) {
    public List<BookingDto> getBookings() {
        return bookingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public BookingDetailDto getBookingById(Long id) {
        return bookingRepository.findByBookingId(id)
                .map(this::mapToDetailDto)
                .orElse(null);
    }

    public BookingDto createBooking(String flightId, PassengerEntity passengerInfo) {
        BookingEntity bookingEntity = new BookingEntity();
        FlightEntity flight = flightRepository.findByFlightNumber(flightId);
        bookingEntity.setFlight(flight);
        bookingEntity.setBookingTime(LocalDateTime.now());
        bookingEntity.setReference("AAA");
        bookingEntity.setStatus("2");
        bookingRepository.save(bookingEntity);
        return new BookingDto();
    }

    private BookingDto mapToDto(BookingEntity entity) {
        BookingDto Dto = new BookingDto();
        BeanUtils.copyProperties(entity, Dto);
        return Dto;
    }

    private BookingDetailDto mapToDetailDto(BookingEntity entity) {
        BookingDetailDto Dto = new BookingDetailDto();
        BeanUtils.copyProperties(entity, Dto);
        return Dto;
    }
}
