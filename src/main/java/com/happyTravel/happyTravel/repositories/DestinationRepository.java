package com.happyTravel.happyTravel.repositories;

import com.happyTravel.happyTravel.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
    List<Destination> findAllByOrderByIdAsc();
}
