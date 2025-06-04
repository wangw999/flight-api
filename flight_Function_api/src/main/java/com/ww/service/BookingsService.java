package com.ww.service;

import com.ww.dto.BookingDetailDto;
import com.ww.dto.BookingDto;
import com.ww.entity.BookingEntity;
import com.ww.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingsService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingsService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    public List<BookingDto> getBookings(int page, int size) {
        return bookingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public BookingDetailDto getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(this::mapToDetailDto)
                .orElse(null);
    }


    public BookingDto createBooking(Long flightId, Object passengerInfo) {
        return new BookingDto();
    }

    private BookingDto mapToDto(BookingEntity entity) {
        BookingDto Dto = new BookingDto();
//        Dto.setReference(entity.getReference());
//        Dto.setRoute(entity.getRoute());
//        Dto.setDate(entity.getDate());
//        Dto.setStatus(entity.getStatus());
        return Dto;
    }

    private BookingDetailDto mapToDetailDto(BookingEntity entity) {
        BookingDetailDto Dto = new BookingDetailDto();
//        Dto.setReference(entity.getReference());
//        Dto.setRoute(entity.getRoute());
//        Dto.setDate(entity.getDate());
//        Dto.setStatus(entity.getStatus());
//        Dto.setPrice(0.0); // 假设此处设置价格
//        Dto.setAirline(""); // 假设此处设置航司
        return Dto;
    }
}
