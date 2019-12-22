package com.github.vihaan.adinxwebsite.mappers;

import com.github.vihaan.adinxwebsite.trips.Destination;
import com.github.vihaan.adinxwebsite.trips.DestinationDTO;
import com.github.vihaan.adinxwebsite.users.Role;
import com.github.vihaan.adinxwebsite.users.RoleDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("destinationMapper")
public class DestinationMapper implements IMapper<Destination, DestinationDTO>{
    @Override
    public DestinationDTO convertEntityToDto(Destination entity) {
        return null;
    }

    @Override
    public Destination convertDtoToEntity(DestinationDTO dto) {
        return null;
    }
}
