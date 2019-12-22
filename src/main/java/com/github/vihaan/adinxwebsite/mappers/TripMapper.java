package com.github.vihaan.adinxwebsite.mappers;

import com.github.vihaan.adinxwebsite.trips.Trip;
import com.github.vihaan.adinxwebsite.trips.TripDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("tripMapper")
public class TripMapper implements IMapper<Trip, TripDTO> {
    @Override
    public TripDTO convertEntityToDto(Trip entity) {
        return null;
    }

    @Override
    public Trip convertDtoToEntity(TripDTO dto) {
        return null;
    }
}
