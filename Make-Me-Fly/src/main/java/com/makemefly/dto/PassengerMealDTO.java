package com.makemefly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerMealDTO {

    private int passengerId;
    private String passengerName;
    private String mealType;
}
