package com.makemefly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableFlightsDTO {

    private int flightScheduleId;
    private int flightId;
    private String flightName;
    private double businessSeatCost;
    private double nonBusinessSeatCost;
    private int departurePlaceId;
    private int destinationPlaceId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String departurePlace;
    private String arrivalPlace;

}
