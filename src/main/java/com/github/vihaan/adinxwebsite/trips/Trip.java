package com.github.vihaan.adinxwebsite.trips;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
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

    public Trip(LocalDate start_date, LocalDate end_date, Destination tripDestination) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.tripDestination = tripDestination;
    }
}
