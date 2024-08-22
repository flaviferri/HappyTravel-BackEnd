package com.happyTravel.happyTravel.controllers;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.services.DestinationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService){

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


    @PostMapping("/destinations")
    public ResponseEntity<Object> addDestination(@RequestBody Destination destination) {
        return destinationService.addDestination(destination);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>delete(@PathVariable("id")int id){
        Optional<Destination> existingDestination = this.destinationService.finById(id);
        if(existingDestination.isPresent()){
            this.destinationService.delete(existingDestination.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
