package com.tw.itamnl.minipackage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.itamnl.minipackage.model.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
@ActiveProfiles(profiles = "bookingTest")
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void should_return_created_status_when_create_valid_booking() throws Exception {
        Booking booking = new Booking();
        ResultActions result = mockMvc.perform(post("/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(booking)));
        result.andExpect(status().isCreated());
    }


    @Test
    public void should_return_all_bookings() throws Exception {
        ResultActions result = mockMvc.perform(get("/bookings"));
        result.andExpect(status().isOk());
    }
}