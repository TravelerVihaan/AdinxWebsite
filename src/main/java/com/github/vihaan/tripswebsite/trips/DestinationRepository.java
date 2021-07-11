package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.trips.destinations.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    Optional<Destination> findByDestination(String destination);
}
