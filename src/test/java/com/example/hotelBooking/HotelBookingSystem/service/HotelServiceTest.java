package com.example.hotelBooking.HotelBookingSystem.service;

import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import com.example.hotelBooking.HotelBookingSystem.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HotelServiceTest {
    @InjectMocks
    HotelService hotelService;
    @Mock
    HotelRepository hotelRepository;

    @Test
    void whenValidHotels_getAllHotels_thenReturnValidSize() throws Exception {
        List<Hotel> mockHotelList = Arrays.asList(
                new Hotel(1L, "Hotel 1", "Address 1"),
                new Hotel(2L, "Hotel 2", "Address 2")
                // Add more hotels as needed
        );
       when(hotelRepository.findAll()).thenReturn(mockHotelList);
       List<Hotel> hotelList = hotelService.getAllHotels();
       assertEquals(hotelList.size(),mockHotelList.size());

    }

}