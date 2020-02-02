package com.github.vihaan.tripswebsite.trips;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.Objects;

public class DestinationDTO {

    @NotEmpty(message = "{destination.empty.dest}")
    private String destination;

    @NotNull
    @PositiveOrZero(message = "{destination.wrong.price}")
    private double normalPrice;

    @NotNull
    @PositiveOrZero(message = "{destination.wrong.price}")
    private double reducedPrice;

    private List<TripDTO> trips;

    public DestinationDTO(){}
    public DestinationDTO(@NotEmpty String destination,
                          @NotNull @PositiveOrZero double normalPrice,
                          @NotNull @PositiveOrZero double reducedPrice) {
        this.destination = destination;
        this.normalPrice = normalPrice;
        this.reducedPrice = reducedPrice;
    }

    public DestinationDTO(@NotEmpty String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
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
        return Double.compare(that.normalPrice, normalPrice) == 0 &&
                Double.compare(that.reducedPrice, reducedPrice) == 0 &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, normalPrice, reducedPrice);
    }

    @Override
    public String toString() {
        return "DestinationDTO{" +
                "destination='" + destination + '\'' +
                ", normalPrice=" + normalPrice +
                ", reducedPrice=" + reducedPrice +
                '}';
    }
}
