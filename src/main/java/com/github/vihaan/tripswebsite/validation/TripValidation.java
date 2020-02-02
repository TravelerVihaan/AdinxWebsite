package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.trips.TripDTO;
import com.github.vihaan.tripswebsite.trips.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("tripValidation")
public class TripValidation implements IValidation<TripDTO>{

    private TripRepository tripRepository;

    @Autowired
    public TripValidation(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<String> isValid(TripDTO objectToValidate) {
        List<String> validationErrors = validatorCheck(objectToValidate);
        if(validateDates(objectToValidate))
            validationErrors.add(IValidationMessages.DATES_CONFLICT);
        return validationErrors;
    }

    private boolean validateDates(TripDTO trip){
        return trip.getEndDate().isAfter(trip.getEndDate());
    }
}
