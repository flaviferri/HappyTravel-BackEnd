package com.happyTravel.happyTravel.repositories;

import com.happyTravel.happyTravel.models.Destination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class DestinationRepositoryIntegrationTest {

    @Autowired
    private DestinationRepository destinationRepository;

    @Test
    void testSaveAndFindById() {

        Destination destination = new Destination();
        destination.setName("Tokyo");
        destination.setCountry("Japan");
        destination.setImage("tokyo.jpg");
        destination.setMessage("Amazing city");
        destination.setId_user(1);


        Destination savedDestination = destinationRepository.save(destination);


        Optional<Destination> foundDestination = destinationRepository.findById(savedDestination.getId());

        assertThat(foundDestination).isPresent();
        assertThat(foundDestination.get().getName()).isEqualTo("Tokyo");
        assertThat(foundDestination.get().getCountry()).isEqualTo("Japan");
    }

    @Test
    void testFindAll() {

        Destination destination1 = new Destination().setName("Paris").setCountry("France").setImage("paris.jpg").setMessage("Beautiful city").setId_user(1);
        Destination destination2 = new Destination().setName("London").setCountry("UK").setImage("london.jpg").setMessage("Great city").setId_user(2);

        destinationRepository.save(destination1);
        destinationRepository.save(destination2);

        List<Destination> destinations = destinationRepository.findAll();

        assertThat(destinations).hasSize(2);
        assertThat(destinations).extracting(Destination::getName).containsExactlyInAnyOrder("Paris", "London");
    }

    @Test
    void testDelete() {

        Destination destination = new Destination().setName("Tokyo").setCountry("Japan").setImage("tokyo.jpg").setMessage("Amazing city").setId_user(1);
        destination = destinationRepository.save(destination);

        destinationRepository.delete(destination);

        Optional<Destination> foundDestination = destinationRepository.findById(destination.getId());
        assertThat(foundDestination).isNotPresent();
    }
}