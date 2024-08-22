package com.happyTravel.happyTravel.services;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.repositories.DestinationRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestination() {
        return destinationRepository.findAll();
    }

    public ResponseEntity<Object> addDestination(Destination destination) {
        destinationRepository.save(destination);
        return new ResponseEntity<>(destination, HttpStatus.CREATED);
    }

    public void delete (Destination destination){
        this.destinationRepository.delete(destination);

    }

    public Optional<Destination> finById(int id){
        return destinationRepository.findById(id);
    }
}
