package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.trips.Destination;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.Validation;

@Service
@Qualifier("destinationValidation")
public class DestinationValidation implements IValidation<Destination> {

    @Override
    public HttpStatusEnum isValid(Destination objectToValidate) {
        return null;
    }
}
