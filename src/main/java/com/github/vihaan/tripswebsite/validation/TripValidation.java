package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.trips.TripDTO;
import com.github.vihaan.tripswebsite.trips.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("tripValidation")
public class TripValidation implements IValidation<TripDTO>{

    private TripRepository tripRepository;

    @Autowired
    public TripValidation(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public boolean isValid(TripDTO objectToValidate) {
        if(!validatorCheck(objectToValidate)){
            return false;
        }
        return validateDates(objectToValidate);
    }

    private boolean validateDates(TripDTO trip){
        return trip.getEnd_date().isAfter(trip.getEnd_date());
    }
}
