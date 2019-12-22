package com.github.vihaan.adinxwebsite.trips;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Objects;

public class TripDTO {

    @NotEmpty
    @Future
    private LocalDate start_date;

    @NotEmpty
    @Future
    private LocalDate end_date;

    @NotEmpty
    private String destination;

    public TripDTO() { }
    public TripDTO(@NotEmpty @Future LocalDate start_date, @NotEmpty @Future LocalDate end_date, @NotEmpty String destination) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.destination = destination;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
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
        TripDTO tripDTO = (TripDTO) o;
        return Objects.equals(start_date, tripDTO.start_date) &&
                Objects.equals(end_date, tripDTO.end_date) &&
                Objects.equals(destination, tripDTO.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start_date, end_date, destination);
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "start_date=" + start_date +
                ", end_date=" + end_date +
                ", destination='" + destination + '\'' +
                '}';
    }
}
