package com.example.hotelBooking.HotelBookingSystem.controllers;
import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import com.example.hotelBooking.HotelBookingSystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return hotel != null ? ResponseEntity.ok(hotel) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }
}
