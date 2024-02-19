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
        return ResponseEntity.ok(reservationService.getReservationsByHotel(hotelId)).getBody();
    }



    @PostMapping("/{hotelId}")
    public ResponseEntity<Reservation> makeReservation(
            @PathVariable Long hotelId,
            @RequestBody Reservation reservation) {
        return
                ResponseEntity.status(HttpStatus.CREATED).body(reservationService.makeReservation(hotelId, reservation));
    }

    @PatchMapping("/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}