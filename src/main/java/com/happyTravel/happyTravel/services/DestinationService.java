package com.happyTravel.happyTravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestination() {
        return destinationRepository.findAllByOrderByIdAsc();
    }

    public ResponseEntity<Object> addDestination(Destination destination) {
        destinationRepository.save(destination);
        return new ResponseEntity<>(destination, HttpStatus.CREATED);
    }

    public void delete(Destination destination) {
        this.destinationRepository.delete(destination);

    }
    public ResponseEntity<Object> udpateDestination(int id, Destination destination) {
        Optional<Destination> existingDestination = destinationRepository.findById(id);
        if (existingDestination.isPresent()) {
            Destination updateDestination = existingDestination.get();
            updateDestination.setName(destination.getName());
            updateDestination.setCountry(destination.getCountry());
            updateDestination.setImage(destination.getImage());
            updateDestination.setMessage(destination.getMessage());
            destinationRepository.save(updateDestination);
            return new ResponseEntity<>(updateDestination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Destino no encontrado", HttpStatus.NOT_FOUND);
        }
    }
    public Optional<Destination> finById(int id) {
        return destinationRepository.findById(id);
    }


    public Optional<Destination> getDestinationById(int id) {
        return destinationRepository.findById(id);
    }



}



