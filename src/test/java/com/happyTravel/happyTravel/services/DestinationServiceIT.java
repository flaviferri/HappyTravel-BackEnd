package com.happyTravel.happyTravel.services;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.repositories.DestinationRepository;

@SpringBootTest
@Transactional 
public class DestinationServiceIT {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private DestinationRepository destinationRepository;

    @Test
void testGetDestination() {

    Destination destination1 = new Destination().setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);
    Destination destination2 = new Destination().setName("London").setCountry("UK").setImage("london.jpg").setMessage("Great city").setId_user(2);
    Destination destination3 = new Destination().setName("China").setCountry("China").setImage("china.jpg").setMessage("Amazing culture").setId_user(3);
    destinationRepository.save(destination1);
    destinationRepository.save(destination2);
    destinationRepository.save(destination3);


    List<Destination> destinations = destinationService.getDestination();


    assertThat(destinations)
        .extracting(destination -> destination.getName().trim());
}
    @Test
    void testAddDestination() {

        Destination destination = new Destination().setName("Rome").setCountry("Italy").setImage("rome.jpg").setMessage("Historic city").setId_user(3);

        ResponseEntity<Object> response = destinationService.addDestination(destination);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isInstanceOf(Destination.class);

        Optional<Destination> savedDestination = destinationRepository.findById(((Destination) response.getBody()).getId());
        assertThat(savedDestination).isPresent();
    }

    @Test
    void testUpdateDestination() {

        Destination destination = new Destination().setName("Berlin").setCountry("Germany").setImage("berlin.jpg").setMessage("Vibrant city").setId_user(4);
        destinationRepository.save(destination);

        Destination updatedDestination = new Destination().setName("Berlin Updated").setCountry("Germany Updated").setImage("berlin_updated.jpg").setMessage("Updated city");

        ResponseEntity<Object> response = destinationService.udpateDestination(destination.getId(), updatedDestination);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(((Destination) response.getBody()).getName()).isEqualTo("Berlin Updated");

        Optional<Destination> updatedDestinationFromDb = destinationRepository.findById(destination.getId());
        assertThat(updatedDestinationFromDb).isPresent();
        assertThat(updatedDestinationFromDb.get().getName()).isEqualTo("Berlin Updated");
    }

    @Test
    void testDeleteDestination() {

        Destination destination = new Destination().setName("Amsterdam").setCountry("Netherlands").setImage("amsterdam.jpg").setMessage("Canal city").setId_user(5);
        destinationRepository.save(destination);

        destinationService.delete(destination);

        Optional<Destination> deletedDestination = destinationRepository.findById(destination.getId());
        assertThat(deletedDestination).isNotPresent();
    }

    @Test
    void testGetDestinationById() {

        Destination destination = new Destination().setName("Tokyo").setCountry("Japan").setImage("tokyo.jpg").setMessage("Modern city").setId_user(6);
        destinationRepository.save(destination);

        Optional<Destination> foundDestination = destinationService.getDestinationById(destination.getId());

        assertThat(foundDestination).isPresent();
        assertThat(foundDestination.get().getName()).isEqualTo("Tokyo");
    }
}