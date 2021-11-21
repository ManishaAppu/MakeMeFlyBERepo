package com.makemefly.dto;

import com.makemefly.entity.FlightSeats;
import com.makemefly.entity.Meal;
import com.makemefly.entity.TicketBookingDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {
    private int passengerId;
    private String passengerName;
    private String gender;
    private FlightSeats flightSeat;
    private Meal meal;

}
