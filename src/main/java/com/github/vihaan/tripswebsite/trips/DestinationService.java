package com.github.vihaan.tripswebsite.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationService {

    private DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    private DestinationDTO getDestination(String dest){
        Optional<Destination> destination = destinationRepository.findByDestination(dest);
    }
}
