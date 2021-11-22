package com.makemefly.service;

import com.makemefly.Exception.AirlineNotFoundException;
import com.makemefly.Exception.TicketNotFoundException;
import com.makemefly.dto.AvailableFlightsDTO;
import com.makemefly.dto.FlightSearchDTO;
import com.makemefly.dto.PassengerDTO;
import com.makemefly.dto.TicketBookingDTO;
import com.makemefly.entity.*;
import com.makemefly.mapper.FlightBookingMapper;
import com.makemefly.mapper.PassengerMapper;
import com.makemefly.mapper.PassengerMapperImpl;
import com.makemefly.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketReservationService {

    @Autowired
    private TicketReservationRepository ticketReservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerMapper passengerMapper;

    @Autowired
    private FlightBookingMapper flightBookingMapper;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightScheduleRepository flightScheduleRepository;



    public TicketBookingDetails bookFlightTicket(TicketBookingDTO ticketBookingDTO){
        TicketBookingDetails ticketBookingDetails = flightBookingMapper.mapToTicketBookingDetails(ticketBookingDTO);
        ticketBookingDetails.setTravelDate(ticketBookingDTO.getTravelDate());
        ticketBookingDetails.setPnrNo(generatePNR());
        ticketBookingDetails.setIsActive(1);
        ticketBookingDetails.setBookingFlight(ticketBookingDTO.getFlightSchedule());
        double businessTicketCostPerTicket = (Double)flightScheduleRepository.getBusinessSeatCostByFlightScheduleId(ticketBookingDetails.getBookingFlight().getFlightScheduleId());
        double nonBusinessTicketCostPerTicket = (Double)flightScheduleRepository.getNonBusinessSeatCostByFlightScheduleId(ticketBookingDetails.getBookingFlight().getFlightScheduleId());
        double businessSeatCost = businessTicketCostPerTicket * ticketBookingDTO.getNoOfBusinessSeatsBooking();
        double nonBusinessSeatCost = nonBusinessTicketCostPerTicket * ticketBookingDTO.getNoOfNonBusinessSeatsBooking();

        ticketBookingDetails.setTicketCost(businessSeatCost + nonBusinessSeatCost);

        TicketBookingDetails ticketBooked = ticketReservationRepository.save(ticketBookingDetails);
        addPassengers(ticketBookingDTO.getPassengerList(), ticketBooked);
       return ticketBooked;
    }


    public String generatePNR(){
        String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
       StringBuilder builder = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            builder.append( alphaNumeric.charAt(random.nextInt(alphaNumeric.length())));
        }
        return builder.toString();
    }

    public void addPassengers(List<PassengerDTO> passengerDTOS, TicketBookingDetails ticketBooked){
        passengerDTOS.forEach(passengerDTO -> {
                Passenger passenger = passengerMapper.mapToPassenger(passengerDTO);
                passenger.setTicketId(ticketBooked);
                passengerRepository.save(passenger);
            });
    }

    public List<TicketBookingDetails> getAllTicketsBooked(){
        return ticketReservationRepository.findAll();
    }

    public TicketBookingDetails getTicketsByTicketId(int ticketBookingId) throws TicketNotFoundException {
        TicketBookingDetails ticketBookingDetails = ticketReservationRepository.findByTicketBookingId(ticketBookingId);
                if(ticketBookingDetails != null)
        return ticketBookingDetails;
                else throw new TicketNotFoundException(" Ticket Not Found for this ticket Id "+ ticketBookingId);
    }

    public String cancelTicketsByTicketId(int ticketBookingId) throws TicketNotFoundException {
        int canceledTicket = ticketReservationRepository.cancelTicket(ticketBookingId);
        if(canceledTicket != 0){
            return "Ticked Cancelled Successfully";
        }else{
            throw new TicketNotFoundException("Airline Not Exist");
        }
    }

    public List<AvailableFlightsDTO> getAvailableFlights(FlightSearchDTO flightSearchDTO){
      return flightScheduleRepository.getListOfAvailableFlights(flightSearchDTO.getDeparturePlaceId(), flightSearchDTO.getDestinationPlaceId(), flightSearchDTO.getTravelDate());
    }
}
