package com.makemefly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties("ticketId")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerId;
    private String passengerName;
    private String gender;

    @OneToOne
    @JoinColumn(name = "flightSeatId")
    private FlightSeats flightSeat;

    @OneToOne
    @JoinColumn(name="mealPreferenceId", referencedColumnName = "mealId")
    private Meal meal;

    @OneToOne
    @JoinColumn(name="ticketId")
    private TicketBookingDetails ticketId;

}
