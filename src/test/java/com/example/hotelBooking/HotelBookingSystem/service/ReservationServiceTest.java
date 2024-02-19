package com.example.hotelBooking.HotelBookingSystem.service;

import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import com.example.hotelBooking.HotelBookingSystem.entities.Reservation;
import com.example.hotelBooking.HotelBookingSystem.repository.HotelRepository;
import com.example.hotelBooking.HotelBookingSystem.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReservationServiceTest {
    @InjectMocks
    ReservationService reservationService;
    @Mock
    ReservationRepository reservationRepository;

    @Test
    void whenNoReservations_getAllReservations_thenReturnZeroSize() throws Exception {
        when(reservationRepository.findAll()).thenReturn(Collections.emptyList());
        List<Reservation> res = reservationService.getAllReservations();
        assertEquals(res.size(),0);

    }
}