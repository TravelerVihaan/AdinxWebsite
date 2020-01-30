package com.github.vihaan.tripswebsite.mappers;

import com.github.vihaan.tripswebsite.trips.Destination;
import com.github.vihaan.tripswebsite.trips.DestinationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("destinationMapper")
public class DestinationMapper implements IMapper<Destination, DestinationDTO>{

    private ModelMapper modelMapper;

    @Autowired
    public DestinationMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public DestinationDTO convertEntityToDto(Destination entity) {
        return modelMapper.map(entity, DestinationDTO.class);
    }

    @Override
    public Destination convertDtoToEntity(DestinationDTO dto) {
        return modelMapper.map(dto, Destination.class);
    }
}
