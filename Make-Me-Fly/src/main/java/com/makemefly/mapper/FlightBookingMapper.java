package com.makemefly.mapper;

import com.makemefly.dto.TicketBookingDTO;
import com.makemefly.entity.TicketBookingDetails;
import com.makemefly.service.TicketReservationService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightBookingMapper {
    TicketBookingDetails mapToTicketBookingDetails(TicketBookingDTO ticketBookingDTO);
}
