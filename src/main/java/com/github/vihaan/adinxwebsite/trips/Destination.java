package com.github.vihaan.adinxwebsite.trips;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @Column(name = "id_destination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String destination;

    @OneToMany(mappedBy= "tripDestination")
    private List<Trip> trips;

    public Destination(){}
    public Destination(String destination) {
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(trips, that.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, trips);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", trips=" + trips +
                '}';
    }
}
