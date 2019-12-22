package com.github.vihaan.adinxwebsite.trips;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

public class DestinationDTO {

    @NotEmpty
    private String destination;

    private List<TripDTO> trips;

    public DestinationDTO() {}
    public DestinationDTO(@NotEmpty String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<TripDTO> getTrips() {
        return trips;
    }

    public void setTrips(List<TripDTO> trips) {
        this.trips = trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationDTO that = (DestinationDTO) o;
        return Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    @Override
    public String toString() {
        return "DestinationDTO{" +
                "destination='" + destination + '\'' +
                ", trips=" + trips +
                '}';
    }
}
