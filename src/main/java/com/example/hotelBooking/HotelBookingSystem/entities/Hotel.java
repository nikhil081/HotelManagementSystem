package com.example.hotelBooking.HotelBookingSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    private String address;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}