package com.github.vihaan.tripswebsite.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class EntityDTOMapper {

    @Bean
    public final ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
