package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.trips.TripDTO;
import com.github.vihaan.adinxwebsite.trips.TripRepository;
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
        return false;
    }
}
