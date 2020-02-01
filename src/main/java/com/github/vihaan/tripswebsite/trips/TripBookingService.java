package com.github.vihaan.tripswebsite.trips;

import org.springframework.stereotype.Service;

@Service
public class TripBookingService {

    private TripRepository tripRepository;
    private DestinationService destinationService;
}
