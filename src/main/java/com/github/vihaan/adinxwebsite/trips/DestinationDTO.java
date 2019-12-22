package com.github.vihaan.adinxwebsite.trips;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class DestinationDTO {

    @NotEmpty
    private String destination;

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
                '}';
    }
}
