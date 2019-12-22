package com.github.vihaan.adinxwebsite.trips;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
}
