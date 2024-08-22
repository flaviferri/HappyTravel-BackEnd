package com.happyTravel.happyTravel.models.controllers;

import com.happyTravel.happyTravel.models.Destination;
import com.happyTravel.happyTravel.services.DestinationService;
import org.springframework.web.bind.annotation.GetMapping;
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
}
