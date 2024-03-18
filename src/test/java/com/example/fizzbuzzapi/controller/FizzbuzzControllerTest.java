package com.example.fizzbuzzapi.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.fizzbuzzapi.model.Fizzbuzz;
import com.example.fizzbuzzapi.service.FizzbuzzService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.*;
import java.util.Optional;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(FizzbuzzController.class)
public class FizzbuzzControllerTest {

    // using Spring's @Autowired annotation to inject an instance of MockMvc into this class
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzbuzzService fizzbuzzService;

    @Autowired
    ObjectMapper objectMapper;


    private static final String[] userAgents = {
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36"
    };

    // This generates a random number
    private static final Random randomNum = new Random();

    // This generates a random index between 0 and the length of the userAgents array - 1
    private static int randomIndex = randomNum.nextInt(userAgents.length);

    // This generates a random user agent
    public static <randomIndex> String generateRandomUserAgent() {
        return userAgents[randomIndex];
    }

    String randomUserAgent = generateRandomUserAgent();

    // This generates a random date and stores it in a variable
    Date randomDate = new Date();


    Fizzbuzz fizzbuzz1 = new Fizzbuzz(1L, randomUserAgent, randomDate, "message 1");
    Fizzbuzz fizzbuzz2 = new Fizzbuzz(2L, randomUserAgent, randomDate, "message 2");
    Fizzbuzz fizzbuzz3 = new Fizzbuzz(3L, randomUserAgent, randomDate, "message 3");


    /**
     * This test verifies that the GET all method in the controller class successfully retrieves all Fizzbuzz records and returns the expected response status and payload.
     *
     * When it creates a mock of the Fizzbuzz service, it mocks its behavior by calling the GET all method and expecting it to then return a list of Fizzbuzz objects.
     *
     * Then, it uses mockMvc to perform (using MockMvcRequestBuilders) a GET request to the corresponding endpoint ("/api/fizzbuzz/").
     * Set the content type you're expecting, which is MediaType.APPLICATION_JSON.
     * And expect the status is ok.
     * And expect the jsonPath of the "data" key of the response payload to have a size of 3 (representing the number of Fizzbuzz records).
     * And expect the jsonPath of the "message" key of the response payload to have a value of "success".
     * And print the message.
     *
     * @throws Exception if list of fizzbuzzes not found
     */
    @Test
    public void getAllFizzbuzzRecords_success() throws Exception {
        List<Fizzbuzz> fizzbuzzList = new ArrayList<>(Arrays.asList(fizzbuzz1, fizzbuzz2, fizzbuzz3));

        when(fizzbuzzService.getAllFizzbuzzes()).thenReturn(fizzbuzzList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/fizzbuzz/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // jsonPath helps us check that we have a data key (which represents the "data" key from Postman for this particular HTTP request) and a message key. '$' represents the payload
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }


    /**
     * This test verifies that the GET by id method in the controller class successfully retrieves a specific Fizzbuzz record by its id and returns the expected response status and payload.
     *
     * When it creates a mock of the Fizzbuzz service, it mocks its behavior by calling the GET by id method and expecting it to then return an individual Fizzbuzz object.
     *
     * Then, it uses mockMvc to perform (using MockMvcRequestBuilders) a GET request to the corresponding endpoint and uri variable ("/api/fizzbuzz/{id}/", "1").
     * Set the content type you're expecting, which is MediaType.APPLICATION_JSON.
     * And expect the status is ok.
     * And expect the jsonPath of the "message" key of the response payload to have a value of "success".
     * And print the message.
     *
     * @throws Exception if specific fizzbuzz object not found
     */
    @Test
    public void getFizzbuzzRecord_success() throws Exception {

        when(fizzbuzzService.getFizzbuzzById(fizzbuzz1.getFizzbuzzId())).thenReturn(Optional.of(fizzbuzz1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/fizzbuzz/{id}/", "1")             .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }


    /**
     * This test verifies that the POST method in the controller class successfully creates a new Fizzbuzz record and returns the expected response status and payload.
     *
     * When it creates a mock of the Fizzbuzz service, it mocks its behavior by calling the POST method,  creating a mock of any Fizzbuzz object, and expecting it to then return a newly created Fizzbuzz object.
     *
     * Then, using MockHttpServletRequestBuilder it initializes a variable, "mockRequest" as equal to using MockMvcRequestBuilders to call a POST request to the corresponding endpoint ("/api/fizzbuzz/").
     * Set the content type you're expecting, which is MediaType.APPLICATION_JSON.
     * Accept the content and convert it from Java to JSON, using MediaType.APPLICATION_JSON.
     * Take the content and using the object mapper, write the value of the fizzbuzz record as a string.
     *
     * Then, it uses mockMvc to perform the mockRequest.
     * And expect the status is created.
     * And expect the jsonPath of the response payload to be a not null value.
     * And expect the jsonPath of the "message" key of the response payload to have a value of "success".
     * And print the message.
     *
     * @throws Exception
     */
    @Test
    public void createFizzbuzzRecord_success() throws Exception {

        when(fizzbuzzService.createFizzbuzz(Mockito.any(Fizzbuzz.class), Mockito.anyString()));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/fizzbuzz/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(fizzbuzz1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
