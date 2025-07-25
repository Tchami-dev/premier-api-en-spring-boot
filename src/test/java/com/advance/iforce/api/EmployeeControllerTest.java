package com.advance.iforce.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
 public class EmployeeControllerTest{

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void testGetEmployee() throws Exception{
        mockMvc.perform(get("/employees")).
        andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Laurent")));
        
    }
     
    }

    
