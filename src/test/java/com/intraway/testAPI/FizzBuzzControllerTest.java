package com.intraway.testAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intraway.testAPI.controller.FizzBuzzController;
import com.intraway.testAPI.model.OperationData;
import com.intraway.testAPI.repository.OperationDataRepository;
import com.intraway.testAPI.service.OperationDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzController.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OperationDataService service;

    @Autowired
    private OperationDataRepository operationDataRepository;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

        mvc.perform(get("/intraway/api/fizzbuzz/1/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
