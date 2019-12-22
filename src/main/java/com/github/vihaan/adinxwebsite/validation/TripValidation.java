package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.trips.Trip;
import com.github.vihaan.adinxwebsite.trips.TripDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("tripValidation")
public class TripValidation implements IValidation<TripDTO>{
    @Override
    public HttpStatusEnum isValid(TripDTO objectToValidate) {
        return null;
    }
}
