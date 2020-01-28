package com.github.vihaan.tripswebsite.mappers;

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

    @Autowired
    public TripMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public TripDTO convertEntityToDto(Trip entity) {
        return null;
    }

    @Override
    public Trip convertDtoToEntity(TripDTO dto) {
        return null;
    }
}
