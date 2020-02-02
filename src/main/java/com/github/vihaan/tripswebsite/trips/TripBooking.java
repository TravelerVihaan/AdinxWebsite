package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import com.github.vihaan.tripswebsite.validation.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TripBooking {

    private TripRepository tripRepository;
    private IMapper<Trip, TripDTO> tripMapper;
    private IValidation<TripDTO> tripValidator;
    private DestinationRepository destinationRepository;

    @Autowired
    public TripBooking(@Qualifier("tripMapper") IMapper tripMapper,
                       @Qualifier("tripValidation") IValidation tripValidator,
                       DestinationRepository destinationRepository,
                       TripRepository tripRepository){
        this.tripMapper = tripMapper;
        this.tripValidator = tripValidator;
        this.tripRepository = tripRepository;
        this.destinationRepository = destinationRepository;
    }

    public void executeBooking(TripDTO tripDTO){
        if(!tripValidator.isValid(tripDTO))
            return; //TODO
        tripDTO.setTripCost(calculateTripCost(tripDTO));
        Trip trip = tripMapper.convertDtoToEntity(tripDTO);
        trip.setTripDestination(prepareDestinationEntityToSave(tripDTO));
        tripRepository.save(trip);


    }

    private Destination prepareDestinationEntityToSave(TripDTO tripDTO){
        return destinationRepository.findByDestination(tripDTO.getDestination().getDestination()).orElseThrow();
    }

    private double calculateTripCost(TripDTO tripDTO){
        double cost = tripDTO.getNormalTickets()*tripDTO.getDestination().getNormalPrice();
        cost += tripDTO.getReducedTickets()*tripDTO.getDestination().getReducedPrice();
        return cost;
    }
}
