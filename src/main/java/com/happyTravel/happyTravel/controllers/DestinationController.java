package com.happyTravel.happyTravel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {

        this.destinationService = destinationService;
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @GetMapping("/destinations")
    public ResponseEntity<List<Destination>> getDestination() {
        List<Destination> destinations = destinationService.getDestination();
        if (destinations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(destinations);
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @PostMapping("/destinations/create")
    public ResponseEntity<Object> addDestination(@RequestBody Destination destination) {
        return destinationService.addDestination(destination);
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @DeleteMapping("/destinations/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        Optional<Destination> existingDestination = this.destinationService.finById(id);
        if (existingDestination.isPresent()) {
            this.destinationService.delete(existingDestination.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDestination(@PathVariable("id") int id, @RequestBody Destination destination) {
        return destinationService.udpateDestination(id, destination);
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @GetMapping("/destinations/{id}")
    public ResponseEntity<?> getDestinationById(@PathVariable int id) {
        Optional<Destination> destination = destinationService.getDestinationById(id);
        if (destination.isPresent()) {
            return ResponseEntity.ok(destination.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destination not found");
        }

    }

}
