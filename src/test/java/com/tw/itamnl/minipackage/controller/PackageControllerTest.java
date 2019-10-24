package com.tw.itamnl.minipackage.controller;

import antlr.build.Tool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.itamnl.minipackage.model.Package;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PackageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void should_return_created_status_when_create_valid_booking() throws Exception {
        Package booking = new Package();
        ResultActions result = mockMvc.perform(post("/packages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(booking)));
        result.andExpect(status().isCreated());
    }
}