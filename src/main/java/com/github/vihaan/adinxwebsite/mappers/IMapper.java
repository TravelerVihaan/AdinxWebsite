package com.github.vihaan.adinxwebsite.mappers;

public interface IMapper<T,S> {

    S convertEntityToDto(T entity);

    T convertDtoToEntity(S dto);
}
