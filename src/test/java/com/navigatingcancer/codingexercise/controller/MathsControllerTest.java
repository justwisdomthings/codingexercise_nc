package com.navigatingcancer.codingexercise.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MathsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void giveTwoAndTwo_shouldReturnFour() throws Exception{
        int param1 = 2;
        int param2 = 2;

        mockMvc.perform(get("/math/add")
                .param("parameter1", Integer.toString(param1))
                .param("parameter2", Integer.toString(param2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parameter1").value(param1))
                .andExpect(jsonPath("$.parameter2").value(param2))
                .andExpect(jsonPath("$.result").value(4));
    }


    @Test
    void giveTwoAndFive_shouldReturnSeven() throws Exception{
        int param1 = 2;
        int param2 = 5;

        mockMvc.perform(get("/math/add")
                        .param("parameter1", Integer.toString(param1))
                        .param("parameter2", Integer.toString(param2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.parameter1").value(param1))
                .andExpect(jsonPath("$.parameter2").value(param2))
                .andExpect(jsonPath("$.result").value(7));
    }
}
