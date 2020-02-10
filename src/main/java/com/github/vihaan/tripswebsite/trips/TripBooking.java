package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import com.github.vihaan.tripswebsite.validation.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TripBooking {

    private TripRepositoriesFacade tripRepositoriesFacade;
    private IValidation<TripDTO> tripValidator;

    @Autowired
    public TripBooking(@Qualifier("tripValidation") IValidation tripValidator,
                       TripRepositoriesFacade tripRepositoriesFacade){
        this.tripRepositoriesFacade = tripRepositoriesFacade;
        this.tripValidator = tripValidator;
    }

    public void executeBooking(TripDTO tripDTO){
        if(!tripValidator.isValid(tripDTO).isEmpty())
            return; //TODO
        tripDTO.setTripCost(calculateTripCost(tripDTO));
        IMapper<Trip, TripDTO> tripMapper = tripRepositoriesFacade.getTripMapper();
        Trip trip = tripMapper.convertDtoToEntity(tripDTO);
        trip.setTripDestination(prepareDestinationEntityToSave(tripDTO));
        tripRepositoriesFacade.saveTrip(trip);


    }

    private Destination prepareDestinationEntityToSave(TripDTO tripDTO){
        return tripRepositoriesFacade.getDestinationByName(tripDTO.getDestination().getDestination()).orElseThrow();
    }

    private double calculateTripCost(TripDTO tripDTO){
        double cost = tripDTO.getNormalTickets()*tripDTO.getDestination().getNormalPrice();
        cost += tripDTO.getReducedTickets()*tripDTO.getDestination().getReducedPrice();
        return cost;
    }
}
