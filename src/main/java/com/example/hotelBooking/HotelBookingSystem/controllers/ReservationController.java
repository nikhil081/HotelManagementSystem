package com.example.hotelBooking.HotelBookingSystem.controllers;
import com.example.hotelBooking.HotelBookingSystem.entities.Reservation;
import com.example.hotelBooking.HotelBookingSystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/by-hotel/{hotelId}")
    public List<Reservation> getReservationsByHotel(@PathVariable Long hotelId) {
        return reservationService.getReservationsByHotel(hotelId);
    }

    @GetMapping("/available")
    public List<Reservation> getAvailableRooms(
            @RequestParam Long hotelId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {
        return reservationService.getAvailableRooms(hotelId, checkInDate, checkOutDate);
    }

    @PostMapping("/{hotelId}")
    public ResponseEntity<Reservation> makeReservation(
            @PathVariable Long hotelId,
            @RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.makeReservation(hotelId, reservation);
        return newReservation != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(newReservation) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}