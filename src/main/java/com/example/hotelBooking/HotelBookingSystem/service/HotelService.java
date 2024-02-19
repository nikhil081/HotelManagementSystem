package com.example.hotelBooking.HotelBookingSystem.service;

import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import com.example.hotelBooking.HotelBookingSystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).orElse(null);
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
