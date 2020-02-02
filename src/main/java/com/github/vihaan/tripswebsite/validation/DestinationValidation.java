package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.trips.DestinationDTO;
import com.github.vihaan.tripswebsite.trips.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("destinationValidation")
public class DestinationValidation implements IValidation<DestinationDTO> {

    private DestinationRepository destinationRepository;

    @Autowired
    public DestinationValidation(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    public List<String> isValid(DestinationDTO objectToValidate) {
        List<String> validationErrors = validatorCheck(objectToValidate);
        if(checkIfExistAlready(objectToValidate))
            validationErrors.add(IValidationMessages.DB_CONFLICT);
        return validationErrors;
    }

    private boolean checkIfExistAlready(DestinationDTO destination){
        return destinationRepository.findByDestination(destination.getDestination()).isPresent();
    }
}
