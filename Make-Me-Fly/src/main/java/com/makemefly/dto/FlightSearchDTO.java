package com.makemefly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSearchDTO {

    private LocalDateTime travelDate;
    private int departurePlaceId;
    private int destinationPlaceId;
}
