package com.makemefly.dto;

import com.makemefly.entity.FlightSchedule;
import com.makemefly.entity.Passenger;
import com.makemefly.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBookingDTO {
    private int ticketBookingId;
    private int noOfPassengers;
    private String pnrNo;
    private int noOfBusinessSeatsBooking;
    private int noOfNonBusinessSeatsBooking;
    private LocalDate travelDate;
    private FlightSchedule flightSchedule;
    private String userEmail;
    private List<PassengerDTO> passengerList;
}
