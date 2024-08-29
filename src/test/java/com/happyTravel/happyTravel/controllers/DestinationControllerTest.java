package com.happyTravel.happyTravel.controllers;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.services.DestinationService;

@SpringBootTest
@AutoConfigureMockMvc
class DestinationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DestinationService destinationService;

    @Test
    void testGetDestinations() throws Exception {
<<<<<<< Updated upstream

=======
        // Given
>>>>>>> Stashed changes
        Destination destination = new Destination();
        destination.setName("Paris");
        given(destinationService.getDestination()).willReturn(Collections.singletonList(destination));

<<<<<<< Updated upstream
=======
        // When & Then
>>>>>>> Stashed changes
        mockMvc.perform(get("/destinations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Paris"));
    }

    @Test
    void testAddDestination() throws Exception {
<<<<<<< Updated upstream

=======
        // Given
>>>>>>> Stashed changes
        Destination destination = new Destination();
        destination.setName("Paris");
        given(destinationService.addDestination(any(Destination.class))).willReturn(ResponseEntity.ok().build());

<<<<<<< Updated upstream
=======
        // When & Then
>>>>>>> Stashed changes
        mockMvc.perform(post("/destinations")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Paris\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteDestination() throws Exception {
<<<<<<< Updated upstream

        Destination destination = new Destination();
        given(destinationService.finById(anyInt())).willReturn(Optional.of(destination));

=======
        // Given
        Destination destination = new Destination();
        given(destinationService.finById(anyInt())).willReturn(Optional.of(destination));

        // When & Then
>>>>>>> Stashed changes
        mockMvc.perform(delete("/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateDestination() throws Exception {
<<<<<<< Updated upstream

=======
        // Given
>>>>>>> Stashed changes
        Destination destination = new Destination();
        destination.setName("New York");
        given(destinationService.udpateDestination(anyInt(), any(Destination.class))).willReturn(ResponseEntity.ok().build());

<<<<<<< Updated upstream
=======
        // When & Then
>>>>>>> Stashed changes
        mockMvc.perform(put("/destinations/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"New York\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetDestinationById() throws Exception {
<<<<<<< Updated upstream

=======
        // Given
>>>>>>> Stashed changes
        Destination destination = new Destination();
        destination.setName("Paris");
        given(destinationService.getDestinationById(anyInt())).willReturn(Optional.of(destination));

<<<<<<< Updated upstream
=======
        // When & Then
>>>>>>> Stashed changes
        mockMvc.perform(get("/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Paris"));
    }

    @Test
    void testGetDestinationByIdNotFound() throws Exception {
<<<<<<< Updated upstream

        given(destinationService.getDestinationById(anyInt())).willReturn(Optional.empty());

=======
        // Given
        given(destinationService.getDestinationById(anyInt())).willReturn(Optional.empty());

        // When & Then

>>>>>>> Stashed changes
        mockMvc.perform(get("/{id}", 1))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Destination not found"));
}
}