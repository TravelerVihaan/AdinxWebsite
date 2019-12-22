package com.github.vihaan.adinxwebsite.trips;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "destination")
public class Destination {

    @Id
    @Column(name = "id_destination")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String destination;

    public Destination(){}
    public Destination(String destination) {
        this.destination = destination;
    }
}
