package com.makemefly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightScheduleDTO  {

    private int flightScheduleId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime scheduledStartDate;
    private LocalDateTime scheduledEndDate;
    private int flightId;
    private int departurePlaceId;
    private int destinationPlaceId;
    private int scheduleDaysId;
}
