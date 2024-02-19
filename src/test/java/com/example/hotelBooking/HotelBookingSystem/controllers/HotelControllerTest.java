package com.example.hotelBooking.HotelBookingSystem.controllers;

import com.example.hotelBooking.HotelBookingSystem.entities.Hotel;
import com.example.hotelBooking.HotelBookingSystem.service.HotelService;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HotelControllerTest {

   @InjectMocks HotelController hotelController;
    @Mock
    HotelService hotelService;

    MockMvc mockMvc;

    @BeforeAll
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(hotelController).build();
    }
    @Test
    void getAllHotels() throws Exception {
        List<Hotel> mockHotelList = Arrays.asList(
                new Hotel(1L, "Hotel 1", "Address 1"),
                new Hotel(2L, "Hotel 2", "Address 2")
                // Add more hotels as needed
        );
        lenient().when(hotelController.getAllHotels()).thenReturn(mockHotelList);;
        mockMvc.perform(get("/hotels")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Sample Hotel\", \"address\": \"123 Main St\"}"))
                .andExpect(status().isOk());

    }

}