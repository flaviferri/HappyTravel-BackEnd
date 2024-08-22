package com.happyTravel.repositories;

import com.happyTravel.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {

}
