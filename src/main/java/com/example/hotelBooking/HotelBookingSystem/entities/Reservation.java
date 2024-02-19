package com.example.hotelBooking.HotelBookingSystem.entities;

import com.example.hotelBooking.HotelBookingSystem.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    public Hotel hotel;

    public LocalDate checkInDate;
    public LocalDate checkOutDate;

    @Enumerated(EnumType.STRING)
    public ReservationStatus status;


}
