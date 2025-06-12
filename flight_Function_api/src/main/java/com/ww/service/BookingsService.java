package com.ww.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ww.dto.BookingDetailDto;
import com.ww.dto.BookingDto;
import com.ww.entity.BookingEntity;
import com.ww.entity.FlightEntity;
import com.ww.entity.PassengerEntity;
import com.ww.entity.UserEntity;
import com.ww.repository.BookingRepository;
import com.ww.repository.FlightRepository;
import com.ww.repository.UserRepository;

@Service
public class BookingsService {
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingsService(BookingRepository bookingRepository, FlightRepository flightRepository,
            UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
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

    public BookingDto createBooking(String flightNumber, PassengerEntity passengerInfo) {
        BookingEntity bookingEntity = new BookingEntity();
        BookingEntity bookingEntitySave = new BookingEntity();
        BookingDto bookingDto = new BookingDto();
        FlightEntity flight = flightRepository.findByFlightNumber(flightNumber);
        UserEntity user = userRepository.findByEmail(passengerInfo.getEmail()).orElse(new UserEntity());
        bookingEntity.setFlight(flight);
        bookingEntity.setUser(user);
        bookingEntity.setBookingTime(LocalDateTime.now());
        bookingEntity.setReference("test");
        bookingEntity.setStatus("PENDING");
        bookingEntitySave = bookingRepository.save(bookingEntity);
        bookingDto.setBookingId(bookingEntitySave.getBookingId());

        return bookingDto;
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
