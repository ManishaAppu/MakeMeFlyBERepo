package com.makemefly.mapper;

import com.makemefly.dto.AirlineDTO;
import com.makemefly.entity.Airline;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    Airline mapToAirline(AirlineDTO airlineDTO);
}
