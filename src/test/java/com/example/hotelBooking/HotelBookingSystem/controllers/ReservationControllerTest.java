package com.example.hotelBooking.HotelBookingSystem.controllers;


import com.example.hotelBooking.HotelBookingSystem.service.ReservationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReservationControllerTest {

    @InjectMocks ReservationController reservationController;
    @Mock
    ReservationService reservationService;

    MockMvc mockMvc;

    @BeforeAll
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(reservationController).build();
    }
    @Test
    void getAllHotels() throws Exception {
        lenient().when(reservationController.getAllReservations()).thenReturn(Collections.emptyList());;
        mockMvc.perform(get("/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Sample Hotel\", \"address\": \"123 Main St\"}"))
                .andExpect(status().isOk());

    }

}
