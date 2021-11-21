package com.makemefly.mapper;

import com.makemefly.dto.FlightDTO;
import com.makemefly.entity.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    Flight mapToFlight(FlightDTO flightDTO);
}
