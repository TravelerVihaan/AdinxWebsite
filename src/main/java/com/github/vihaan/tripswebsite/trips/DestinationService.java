package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    private DestinationRepository destinationRepository;
    private IMapper<Destination, DestinationDTO> destinationMapper;

    @Autowired
    public DestinationService(@Qualifier("destinationMapper") IMapper<Destination, DestinationDTO> destinationMapper,
                              DestinationRepository destinationRepository){
        this.destinationMapper = destinationMapper;
        this.destinationRepository = destinationRepository;
    }

    private DestinationDTO getDestination(String dest){
        Optional<Destination> destination = destinationRepository.findByDestination(dest);
        return null; //TODO
    }

    public List<DestinationDTO> getAllDestinations(){
        List<Destination> destinations = destinationRepository.findAll();
        return destinations
                .stream()
                .map(dest -> destinationMapper.convertEntityToDto(dest))
                .collect(Collectors.toList());
    }
}
