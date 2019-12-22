package com.github.vihaan.adinxwebsite.trips;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TripDTO {

    @NotEmpty
    @Future
    private LocalDate start_date;

    @NotEmpty
    @Future
    private LocalDate end_date;

    private String destination;
}
