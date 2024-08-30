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

        when(destinationRepository.findAllByOrderByIdAsc()).thenReturn(List.of(dest1, dest2));

        List<Destination> destinations = destinationService.getDestination();

        assertThat(destinations).hasSize(2);
        assertThat(destinations.get(0).getName()).isEqualTo("Paris");
        assertThat(destinations.get(1).getName()).isEqualTo("London");
}

@Test
void testAddDestination() {
        Destination dest = new Destination().setId(1).setName("Tokyo").setCountry("Japan").setImage("tokyo.jpg").setMessage("Amazing city").setId_user(1);

        when(destinationRepository.save(any(Destination.class))).thenReturn(dest);

        ResponseEntity<Object> response = destinationService.addDestination(dest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(dest);
}

@Test
void testDelete() {
        Destination dest = new Destination().setId(1).setName("Tokyo").setCountry("Japan").setImage("tokyo.jpg").setMessage("Amazing city").setId_user(1);

        destinationService.delete(dest);

        verify(destinationRepository).delete(dest);
}

@Test
void testUpdateDestination() {
        Destination existingDest = new Destination().setId(1).setName("Tokyo").setCountry("Japan").setImage("tokyo.jpg").setMessage("Amazing city").setId_user(1);
        Destination updatedDest = new Destination().setName("Tokyo Updated").setCountry("Japan Updated").setImage("tokyo_updated.jpg").setMessage("Updated city").setId_user(1);

        when(destinationRepository.findById(1)).thenReturn(Optional.of(existingDest));
        when(destinationRepository.save(any(Destination.class))).thenReturn(updatedDest);

        ResponseEntity<Object> response = destinationService.udpateDestination(1, updatedDest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(((Destination) response.getBody()).getName()).isEqualTo("Tokyo Updated");
}

@Test
void testFindById() {
        Destination dest = new Destination().setId(1).setName("Tokyo").setCountry("Japan").setImage("tokyo.jpg").setMessage("Amazing city").setId_user(1);

        when(destinationRepository.findById(1)).thenReturn(Optional.of(dest));

        Optional<Destination> foundDest = destinationService.finById(1);

        assertThat(foundDest).isPresent();
        assertThat(foundDest.get().getName()).isEqualTo("Tokyo");
}

@Test
void testGetDestinationById_NotFound() {
        when(destinationRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Destination> foundDest = destinationService.getDestinationById(1);

        assertThat(foundDest).isNotPresent();
        }
}