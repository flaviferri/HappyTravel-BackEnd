package com.happyTravel.happyTravel.services;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.repositories.DestinationRepository;

class DestinationServiceTest {

    @Mock
    private DestinationRepository destinationRepository;

    @InjectMocks
    private DestinationService destinationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDestination() {

        Destination dest1 = new Destination().setId(1).setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);
        Destination dest2 = new Destination().setId(2).setName("London").setCountry("UK").setImage("london.jpg").setMessage("Great city").setId_user(2);

        when(destinationRepository.findAll()).thenReturn(List.of(dest1, dest2));

        List<Destination> destinations = destinationService.getDestination();

        assertThat(destinations).hasSize(2);
        assertThat(destinations.get(0).getName()).isEqualTo("Paris");
        assertThat(destinations.get(1).getName()).isEqualTo("London");
    }

    @Test
    void testAddDestination() {
        Destination destination = new Destination().setId(1).setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);

        when(destinationRepository.save(any(Destination.class))).thenReturn(destination);

        ResponseEntity<Object> response = destinationService.addDestination(destination);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(destination);

        
        verify(destinationRepository).save(destination);
    }

    @Test
    void testUpdateDestination() {
    
        Destination existingDestination = new Destination().setId(1).setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);
        Destination updatedDestination = new Destination().setName("Paris Updated").setCountry("France Updated").setImage("paris_updated.jpg").setMessage("Updated city");

        when(destinationRepository.findById(1)).thenReturn(Optional.of(existingDestination));
        when(destinationRepository.save(existingDestination)).thenReturn(existingDestination);

        ResponseEntity<Object> response = destinationService.udpateDestination(1, updatedDestination);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(existingDestination);

        verify(destinationRepository).save(existingDestination);
    }

    @Test
    void testDelete() {

        Destination destination = new Destination().setId(1).setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);


        when(destinationRepository.findById(1)).thenReturn(Optional.of(destination));

        destinationService.delete(destination);

        verify(destinationRepository).delete(destination);
    }

    @Test
    void testGetDestinationById() {

        Destination destination = new Destination().setId(1).setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);

        when(destinationRepository.findById(1)).thenReturn(Optional.of(destination));

        Optional<Destination> foundDestination = destinationService.getDestinationById(1);

        assertThat(foundDestination).isPresent();
        assertThat(foundDestination.get()).isEqualTo(destination);
    }
}