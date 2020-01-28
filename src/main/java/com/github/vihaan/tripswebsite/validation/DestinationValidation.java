package com.github.vihaan.tripswebsite.validation;

import com.github.vihaan.tripswebsite.httpstatus.HttpStatusEnum;
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

    public HttpStatusEnum isValid(DestinationDTO objectToValidate) {
        if (!validatorCheck(objectToValidate))
            return HttpStatusEnum.BADREQUEST;
        if (destinationRepository.findByDestination(objectToValidate.getDestination()).isPresent())
            return HttpStatusEnum.CONFLICT;
        return HttpStatusEnum.CREATED;
    }
}
