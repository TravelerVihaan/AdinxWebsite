package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.trips.destinations.DestinationDTO;
import com.github.vihaan.tripswebsite.trips.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("destinationValidation")
class DestinationValidation implements IValidation<DestinationDTO> {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationValidation(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    public List<String> isValid(DestinationDTO objectToValidate) {
        List<String> validationErrors = validatorCheck(objectToValidate);
        if(checkIfExistAlready(objectToValidate))
            validationErrors.add(DB_CONFLICT);
        return validationErrors;
    }

    private boolean checkIfExistAlready(DestinationDTO destination){
        return destinationRepository.findByDestination(destination.getDestination()).isPresent();
    }
}
