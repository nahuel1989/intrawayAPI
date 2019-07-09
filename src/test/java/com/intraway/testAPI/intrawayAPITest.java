package com.intraway.testAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class intrawayAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void save() throws Exception {

        this.mockMvc.perform(get("/intraway/api/fizzbuzz/1/5"))
                .andExpect(status().isOk());
    }

    @Test
    public void badRequest() throws Exception {

        this.mockMvc.perform(get("/intraway/api/fizzbuzz/15/5"))
                .andExpect(status().isBadRequest());
    }
}
