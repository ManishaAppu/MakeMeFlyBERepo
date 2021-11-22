package com.makemefly.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TicketBookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketBookingId;
    private int noOfPassengers;
    private String pnrNo;
    private LocalDate travelDate;
    private Double ticketCost;
    private int isActive ;

    @OneToOne
    @JoinColumn(name ="flight_schedule_id_fk")
    private FlightSchedule bookingFlight;

    @OneToOne
    @JoinColumn(name = "user_id_fk")
    private Users user;

    @OneToMany(mappedBy = "ticketId")
    private List<Passenger> passengerList;

}
