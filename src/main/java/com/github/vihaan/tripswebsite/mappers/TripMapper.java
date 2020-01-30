package com.github.vihaan.tripswebsite.mappers;

import com.github.vihaan.tripswebsite.trips.Destination;
import com.github.vihaan.tripswebsite.trips.DestinationDTO;
import com.github.vihaan.tripswebsite.trips.Trip;
import com.github.vihaan.tripswebsite.trips.TripDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("tripMapper")
public class TripMapper implements IMapper<Trip, TripDTO> {

    private ModelMapper modelMapper;
    private IMapper<Destination, DestinationDTO> destinationMapper;

    @Autowired
    public TripMapper(@Qualifier("destinationMapper") IMapper destinationMapper,
                      ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public TripDTO convertEntityToDto(Trip entity) {
        return modelMapper.map(entity, TripDTO.class);
    }

    @Override
    public Trip convertDtoToEntity(TripDTO dto) {
        Destination destination = destinationMapper.convertDtoToEntity(dto.getDestination());
        Trip trip = modelMapper.map(dto, Trip.class);
        trip.setTripDestination(destination);
        return trip;
    }
}
