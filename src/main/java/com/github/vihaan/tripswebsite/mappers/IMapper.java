package com.github.vihaan.tripswebsite.mappers;

public interface IMapper<T,S> {

    S convertEntityToDto(T entity);

    T convertDtoToEntity(S dto);
}
