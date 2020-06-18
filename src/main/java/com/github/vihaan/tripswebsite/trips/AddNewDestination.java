package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
        import com.github.vihaan.tripswebsite.validation.IValidation;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Service;

@Service
public class AddNewDestination {

    private DestinationRepository destinationRepository;
    private IMapper<Destination, DestinationDTO> destinationMapper;
    private IValidation<DestinationDTO> destinationValidator;

    @Autowired
    public AddNewDestination(@Qualifier("destinationMapper") IMapper destinationMapper,
                             @Qualifier("destinationValidation") IValidation destinationValidator,
                             DestinationRepository destinationRepository){
        this.destinationMapper = destinationMapper;
        this.destinationValidator = destinationValidator;
        this.destinationRepository = destinationRepository;
    }

    public void addNewDestination(DestinationDTO destinationDTO){
        if(!destinationValidator.isValid(destinationDTO).isEmpty())
            return; // TODO
        Destination destination = destinationMapper.convertDtoToEntity(destinationDTO);
        destinationRepository.save(destination);
    }
}
