package com.github.vihaan.tripswebsite.trips;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @Column(name = "id_destination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String destination;

    @Column(name = "normal_price", nullable = false)
    private double normalPrice;

    @Column(name = "reduced_price", nullable = false)
    private double reducedPrice;

    @OneToMany(mappedBy= "tripDestination")
    private List<Trip> trips;

    public Destination(){}
    public Destination(String destination, double normalPrice, double reducedPrice){
        this.destination = destination;
        this.normalPrice = normalPrice;
        this.reducedPrice = reducedPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return id == that.id &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, normalPrice, reducedPrice);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", normalPrice=" + normalPrice +
                ", reducedPrice=" + reducedPrice +
                '}';
    }
}
