package com.github.vihaan.adinxwebsite.validation;

import com.github.vihaan.adinxwebsite.trips.DestinationDTO;
import com.github.vihaan.adinxwebsite.trips.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("destinationValidation")
public class DestinationValidation implements IValidation<DestinationDTO> {

    private DestinationRepository destinationRepository;

    @Autowired
    public DestinationValidation(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    public boolean isValid(DestinationDTO objectToValidate) {
        return false;
    }
}
