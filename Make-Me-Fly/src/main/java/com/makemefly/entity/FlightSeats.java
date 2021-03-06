package com.makemefly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties("flight")
public class FlightSeats {
    public FlightSeats(int flightSeatId) {
        this.flightSeatId = flightSeatId;
    }

    public FlightSeats(int flightSeatId, String flightSeatNumber) {
        this.flightSeatId = flightSeatId;
        this.flightSeatNumber = flightSeatNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightSeatId;
    private String flightSeatNumber;
    private int isBusinessSeat;

    @OneToOne
    @JoinColumn(name="flightId")
    private Flight flight;

}
