package com.makemefly.mapper;

import com.makemefly.dto.PassengerDTO;
import com.makemefly.entity.Passenger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    Passenger mapToPassenger(PassengerDTO passengerDTO);
}
