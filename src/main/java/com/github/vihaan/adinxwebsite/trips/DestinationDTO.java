package com.github.vihaan.adinxwebsite.trips;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DestinationDTO {

    @NotEmpty
    private String destination;
}
