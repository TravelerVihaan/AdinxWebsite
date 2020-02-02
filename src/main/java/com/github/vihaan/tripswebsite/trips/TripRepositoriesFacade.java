package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.mappers.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class TripRepositoriesFacade {

    private TripRepository tripRepository;
    private DestinationRepository destinationRepository;
    private IMapper<Trip, TripDTO> tripMapper;
    private IMapper<Destination, DestinationDTO> destinationMapper;

    @Autowired
    TripRepositoriesFacade(@Qualifier("destinationMapper") IMapper destinationMapper,
                                  @Qualifier("tripMapper")IMapper tripMapper,
                                  TripRepository tripRepository,
                                  DestinationRepository destinationRepository) {
        this.tripRepository = tripRepository;
        this.destinationRepository = destinationRepository;
        this.tripMapper = tripMapper;
        this.destinationMapper = destinationMapper;
    }

    IMapper getTripMapper(){ return tripMapper;}
    IMapper getDestinationMapper(){ return destinationMapper;}

    DestinationDTO getDestinationDtoByDestination(String dest){
        Destination destination = destinationRepository.findByDestination(dest).orElseThrow();
        return destinationMapper.convertEntityToDto(destination);
    }

    Optional<Destination> getDestinationByName(String dest){
        return destinationRepository.findByDestination(dest);
    }

    List<Destination> getAllDestinations(){
        return destinationRepository.findAll();
    }

    List<DestinationDTO> getAllDestinationDtos(){
        return destinationRepository.findAll()
                .stream()
                .map(destination -> destinationMapper.convertEntityToDto(destination))
                .collect(Collectors.toList());
    }

    List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    List<TripDTO> getAllTripDtos(){
        return tripRepository.findAll()
                .stream()
                .map(destination -> tripMapper.convertEntityToDto(destination))
                .collect(Collectors.toList());
    }

    Optional<Trip> getTripById(long id){
        return tripRepository.findById(id);
    }

    TripDTO getTripDtoById(long id){
        Trip trip = tripRepository.findById(id).orElseThrow();
        return tripMapper.convertEntityToDto(trip);
    }

    void saveTrip(Trip trip){
        tripRepository.save(trip);
    }

    void saveDestination(Destination destination){
        destinationRepository.save(destination);
    }
}
