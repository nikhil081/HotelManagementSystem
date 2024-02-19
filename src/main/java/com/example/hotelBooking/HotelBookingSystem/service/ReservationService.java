package com.example.hotelBooking.HotelBookingSystem.service;

import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import com.example.hotelBooking.HotelBookingSystem.entities.Reservation;
import com.example.hotelBooking.HotelBookingSystem.repository.HotelRepository;
import com.example.hotelBooking.HotelBookingSystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByHotel(Long hotelId) {
        return reservationRepository.findByHotelId(hotelId);
    }

    public List<Reservation> getAvailableRooms(Long hotelId, LocalDate checkInDate, LocalDate checkOutDate) {
        return reservationRepository.findByHotelIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(
                hotelId, checkInDate, checkOutDate);
    }

    public Reservation makeReservation(Long hotelId, Reservation reservation) {
        return hotelRepository.findById(hotelId)
                .map(hotel -> {
                    reservation.hotel=hotel;
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new NoSuchElementException("Hotel not found with ID: " + hotelId));
    }
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
