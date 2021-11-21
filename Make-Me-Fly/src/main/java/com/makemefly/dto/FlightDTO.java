package com.makemefly.dto;

import com.makemefly.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    private int flightId;
    private String flightName;
    private int businessSeats;
    private int nonBusinessSeats;
    private double businessSeatCost;
    private double nonBusinessSeatCost;
    private int isActive;
    private int airlineId;
    private List<Meal> meals;
}
