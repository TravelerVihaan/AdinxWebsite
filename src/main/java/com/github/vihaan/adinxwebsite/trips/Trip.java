package com.github.vihaan.adinxwebsite.trips;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @Column(name = "id_trip")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name="destination_id")
    private Destination tripDestination;

    public Trip(){}
    public Trip(LocalDate start_date, LocalDate end_date, Destination tripDestination) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.tripDestination = tripDestination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Destination getTripDestination() {
        return tripDestination;
    }

    public void setTripDestination(Destination tripDestination) {
        this.tripDestination = tripDestination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) &&
                Objects.equals(start_date, trip.start_date) &&
                Objects.equals(end_date, trip.end_date) &&
                Objects.equals(tripDestination, trip.tripDestination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_date, end_date, tripDestination);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", tripDestination=" + tripDestination +
                '}';
    }
}
