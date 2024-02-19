package com.example.hotelBooking.HotelBookingSystem.repository;

import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
