package com.happyTravel.services;


import com.happyTravel.models.Destination;
import com.happyTravel.repositories.DestinationRepository;
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
