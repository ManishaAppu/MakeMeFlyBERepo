package com.makemefly.controller;

import com.makemefly.Exception.TicketNotFoundException;
import com.makemefly.dto.AvailableFlightsDTO;
import com.makemefly.dto.FlightSearchDTO;
import com.makemefly.dto.SearchTicketRequest;
import com.makemefly.dto.TicketBookingDTO;
import com.makemefly.entity.Passenger;
import com.makemefly.entity.TicketBookingDetails;
import com.makemefly.service.TicketReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class TicketReservationController {

    @Autowired
    TicketReservationService ticketReservationService;

    @PostMapping("/bookTicket")
    public TicketBookingDetails bookFlightTicket(@RequestBody TicketBookingDTO ticketBookingDTO){
        return ticketReservationService.bookFlightTicket(ticketBookingDTO);
    }

    @GetMapping("/getAllTickets")
    public List<TicketBookingDetails> getAllTicketsBooked(){
        return ticketReservationService.getAllTicketsBooked();
    }

    @GetMapping("/getTicket/{ticketId}")
    public TicketBookingDetails getTicketByTicketBookingId(@PathVariable int ticketId) throws TicketNotFoundException {
        return ticketReservationService.getTicketsByTicketId(ticketId);
    }

    @PostMapping("/searchFlight")
    public List<AvailableFlightsDTO> getAvailableFlights(@RequestBody FlightSearchDTO flightSearchDTO) {
        return ticketReservationService.getAvailableFlights(flightSearchDTO);
    }

    @PutMapping("/cancelTicket/{ticketId}")
    public ResponseEntity<String> cancelTicketByTicketBookingId(@PathVariable int ticketId) throws TicketNotFoundException {
         ticketReservationService.cancelTicketsByTicketId(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getTicketByUser/{userEmail}")
    public List<TicketBookingDetails> getTicketByUser(@PathVariable String userEmail){
        return ticketReservationService.getTicketByUser(userEmail);
    }

    @PostMapping(value="/getTicketByUserEmail")
    public List<TicketBookingDetails> getTicketByUserEmail(@RequestBody SearchTicketRequest email){
        System.out.println(" Email >>> "+ email.getUserEmail());
        return ticketReservationService.getTicketsByUserEmail(email.getUserEmail());
    }

//    @GetMapping(value="/getPassengerByTicketId/{ticketId}")
//    public List<Passenger> getPassengerByTicketId(@PathVariable int ticketId){
//        return ticketReservationService
//    }
}
