package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.adinxwebsite.trips.Destination;
import com.github.vihaan.adinxwebsite.trips.DestinationDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.Validation;

@Service
@Qualifier("destinationValidation")
public class DestinationValidation implements IValidation<DestinationDTO> {

    @Override
    public HttpStatusEnum isValid(DestinationDTO objectToValidate) {
        return null;
    }
}
