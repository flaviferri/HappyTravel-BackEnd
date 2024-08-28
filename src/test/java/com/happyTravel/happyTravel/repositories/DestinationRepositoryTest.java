package com.happyTravel.happyTravel.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.happyTravel.happyTravel.models.Destination;

@SpringBootTest
class DestinationRepositoryTest {

    @Mock
    private DestinationRepository destinationRepository;

    @InjectMocks
    private DestinationRepositoryTest destinationRepositoryTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveDestination() {
        Destination destination = new Destination();
        destination.setName("Paris");
        destination.setCountry("France");

        when(destinationRepository.save(destination)).thenReturn(destination);

        Destination savedDestination = destinationRepository.save(destination);

        assertThat(savedDestination).isNotNull();
        assertThat(savedDestination.getName()).isEqualTo("Paris");
        assertThat(savedDestination.getCountry()).isEqualTo("France");
    }

    @Test
    void testFindDestinationById() {
        Destination destination = new Destination();
        destination.setId(1);
        destination.setName("Paris");
        destination.setCountry("France");

        when(destinationRepository.findById(1)).thenReturn(Optional.of(destination));

        Optional<Destination> foundDestination = destinationRepository.findById(1);

        assertThat(foundDestination).isPresent();
        assertThat(foundDestination.get().getName()).isEqualTo("Paris");
    }

    @Test
    void testFindAllDestinations() {
        Destination destination1 = new Destination();
        destination1.setName("Paris");
        destination1.setCountry("France");

        Destination destination2 = new Destination();
        destination2.setName("New York");
        destination2.setCountry("USA");

        when(destinationRepository.findAll()).thenReturn(Arrays.asList(destination1, destination2));

        List<Destination> destinations = destinationRepository.findAll();

        assertThat(destinations).hasSize(2);
        assertThat(destinations.get(0).getName()).isEqualTo("Paris");
        assertThat(destinations.get(1).getName()).isEqualTo("New York");
    }

    @Test
    void testDeleteDestination() {
        Destination destination = new Destination();
        destination.setId(1);
        destination.setName("Paris");
        destination.setCountry("France");

        doNothing().when(destinationRepository).deleteById(1);

        destinationRepository.deleteById(1);

        verify(destinationRepository, times(1)).deleteById(1);
    }
}