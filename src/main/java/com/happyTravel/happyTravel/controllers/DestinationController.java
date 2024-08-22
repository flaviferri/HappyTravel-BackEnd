package com.happyTravel.happyTravel.controllers;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.services.DestinationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService){

        this.destinationService = destinationService;
    }

    @GetMapping("/destinations")
    public List<Destination> getDestination(){
        return destinationService.getDestination();
    }

    @PostMapping("/destinations")
    public ResponseEntity<Object> addDestination(@RequestBody Destination destination) {
        return destinationService.addDestination(destination);
    }
}