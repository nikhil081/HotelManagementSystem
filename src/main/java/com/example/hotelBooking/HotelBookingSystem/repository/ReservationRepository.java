package com.example.hotelBooking.HotelBookingSystem.repository;

import com.example.hotelBooking.HotelBookingSystem.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByHotelId(Long hotelId);

    List<Reservation> findByHotelIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(
            Long hotelId, LocalDate checkInDate, LocalDate checkOutDate);
}
