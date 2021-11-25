package com.makemefly.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIgnoreProperties("flight")
public class FlightSchedule {

    public FlightSchedule(int flightScheduleId) {
        this.flightScheduleId = flightScheduleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightScheduleId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime scheduledStartDate;
    private LocalDateTime scheduledEndDate;
    private int isActive;

    @OneToOne
    @JoinColumn(name="flightId")
    private Flight flight;

    @OneToOne
    @JoinColumn(name="departurePlaceId")
    private City departurePlaceId;

    @OneToOne
    @JoinColumn(name="destinationPlaceId")
    private City destinationPlaceId;

    @OneToOne
    @JoinColumn(name="scheduleDaysId")
    private ScheduleDays scheduleDays;
}
