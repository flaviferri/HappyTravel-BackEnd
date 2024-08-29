package com.happyTravel.happyTravel.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.repositories.DestinationRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class DestinationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DestinationRepository destinationRepository;

    @Test
    void testAddDestination() throws Exception {
        String jsonContent = "{ \"name\": \"Tokyo\", \"country\": \"Japan\", \"image\": \"tokyo.jpg\", \"message\": \"Amazing city\", \"id_user\": 1 }";

        mockMvc.perform(post("/destinations")
                .contentType("application/json")
                .content(jsonContent))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Tokyo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("Japan"));
    }

    @Test
    void testGetDestination() throws Exception {

        Destination destination = new Destination();
        destination.setName("Paris");
        destination.setCountry("France");
        destination.setImage("paris.jpg");
        destination.setMessage("Beautiful city");
        destination.setId_user(1);
        destinationRepository.save(destination);

        mockMvc.perform(get("/destinations"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Paris"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].country").value("France"));
    }

    @Test
    void testUpdateDestination() throws Exception {

        Destination destination = new Destination();
        destination.setName("Tokyo");
        destination.setCountry("Japan");
        destination.setImage("tokyo.jpg");
        destination.setMessage("Amazing city");
        destination.setId_user(1);
        destination = destinationRepository.save(destination);

        String jsonContent = "{ \"name\": \"Tokyo Updated\", \"country\": \"Japan Updated\", \"image\": \"tokyo_updated.jpg\", \"message\": \"Updated city\", \"id_user\": 1 }";


        mockMvc.perform(put("/destinations/" + destination.getId())
                .contentType("application/json")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Tokyo Updated"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("Japan Updated"));
    }

    @Test
    void testDeleteDestination() throws Exception {
        // Arrange
        Destination destination = new Destination();
        destination.setName("Tokyo");
        destination.setCountry("Japan");
        destination.setImage("tokyo.jpg");
        destination.setMessage("Amazing city");
        destination.setId_user(1);
        destination = destinationRepository.save(destination);

        mockMvc.perform(delete("/destinations/" + destination.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/destinations/" + destination.getId()))
                .andExpect(status().isNotFound());
    }
}