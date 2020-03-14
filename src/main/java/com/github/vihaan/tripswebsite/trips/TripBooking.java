package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import com.github.vihaan.tripswebsite.validation.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TripBooking {

    private TripRepositoriesFacade tripRepositoriesFacade;
    private IValidation<TripDTO> tripValidator;

    @Autowired
    public TripBooking(@Qualifier("tripValidation") IValidation<TripDTO>  tripValidator,
                       TripRepositoriesFacade tripRepositoriesFacade){
        this.tripRepositoriesFacade = tripRepositoriesFacade;
        this.tripValidator = tripValidator;
    }

    public List<String> executeBooking(TripDTO tripDTO){
        List<String> errors = new ArrayList<>(tripValidator.isValid(tripDTO));
        if(errors.isEmpty()){
            tripDTO.setTripCost(calculateTripCost(tripDTO));
            IMapper<Trip, TripDTO> tripMapper = tripRepositoriesFacade.getTripMapper();
            Trip trip = tripMapper.convertDtoToEntity(tripDTO);
            try {
                trip.setTripDestination(prepareDestinationEntityToSave(tripDTO));
            }catch(NoSuchElementException e){
                errors.clear();
                errors.add(DESTINATION_ERROR);
                return errors;
            }
            tripRepositoriesFacade.saveTrip(trip);
        }
        return errors;

    }

    private Destination prepareDestinationEntityToSave(TripDTO tripDTO){
        return tripRepositoriesFacade.getDestinationByName(tripDTO.getDestination().getDestination()).orElseThrow(NoSuchElementException::new);
    }

    private double calculateTripCost(TripDTO tripDTO){
        double cost = tripDTO.getNormalTickets()*tripDTO.getDestination().getNormalPrice();
        cost += tripDTO.getReducedTickets()*tripDTO.getDestination().getReducedPrice();
        return cost;
    }

    private static final String DESTINATION_ERROR = "Fatal error. This destination does not exist in database.";
}
