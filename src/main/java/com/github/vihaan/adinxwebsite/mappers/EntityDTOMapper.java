package com.github.vihaan.adinxwebsite.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityDTOMapper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
