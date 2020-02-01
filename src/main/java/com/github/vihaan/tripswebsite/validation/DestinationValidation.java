package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.trips.DestinationDTO;
import com.github.vihaan.tripswebsite.trips.DestinationRepository;
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
        if(!validatorCheck(objectToValidate)){
            return false;
        }
        return !checkIfExistAlready(objectToValidate);
    }

    private boolean checkIfExistAlready(DestinationDTO destination){
        return destinationRepository.findByDestination(destination.getDestination()).isPresent();
    }
}
