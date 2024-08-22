package com.happyTravel.happyTravel.services;


import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.repositories.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestination(){
        return destinationRepository.findAll();
    }
}
