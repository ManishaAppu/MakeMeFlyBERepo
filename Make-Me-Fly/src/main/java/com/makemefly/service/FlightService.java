package com.makemefly.service;

import com.makemefly.Constants.CommonConstants;
import com.makemefly.Exception.FlightNotFoundException;
import com.makemefly.dto.FlightDTO;
import com.makemefly.dto.FlightScheduleDTO;
import com.makemefly.dto.FlightScheduleId;
import com.makemefly.entity.*;
import com.makemefly.mapper.FlightMapper;
import com.makemefly.repository.FlightRepository;
import com.makemefly.repository.FlightScheduleRepository;
import com.makemefly.repository.FlightSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @Autowired
    FlightSeatRepository flightSeatRepository;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    EmailSenderService emailSenderService;

    public Flight addFlight(FlightDTO flightDTO){
        Airline  airline = new Airline();
        airline.setAirlineId(flightDTO.getAirlineId());

        Flight flight = flightMapper.mapToFlight(flightDTO);
        flight.setAirline(airline);
        flight.setIsActive(1);
        /*System.out.println(">>> flightDTO.getBusinessSeats() " + flightDTO.getBusinessSeats());
        flight.setBusinessSeats(flightDTO.getBusinessSeats());
        flight.setNonBusinessSeats(flightDTO.getNonBusinessSeats());
        flight.setNonBusinessSeatCost(flightDTO.getNonBusinessSeatCost());
        flight.setBusinessSeatCost(flightDTO.getBusinessSeatCost());
        flight.setFlightName(flightDTO.getFlightName());
        flight.setIsActive(flightDTO.getIsActive());
        flight.setMeals(flightDTO.getMeals());*/

        Flight newFlight = flightRepository.save(flight);

        if(flight.getBusinessSeats()!= 0 ){
            addFlightSeats(CommonConstants.BUSINESS_CLAUSE, flight.getBusinessSeats(), newFlight,1);
        }
        if(flight.getNonBusinessSeats()!= 0 ){
            addFlightSeats(CommonConstants.NON_BUSINESS_CLAUSE, flight.getNonBusinessSeats(), newFlight, 0);
        }



      //  List<FlightSeats> flightSeatList = new ArrayList<>();

        //flight.setFlightSeats(flightSeatList);


       // flightSeatRepository.saveAll(flightSeatList);
        return newFlight;
    }

    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    public FlightSchedule scheduleFlight(FlightScheduleDTO flightScheduleDTO){
        FlightSchedule flightSchedule = new FlightSchedule();
        flightSchedule.setFlight(new Flight(flightScheduleDTO.getFlightId()));
        flightSchedule.setDepartureTime(flightScheduleDTO.getDepartureTime());
        flightSchedule.setArrivalTime(flightScheduleDTO.getArrivalTime());
        flightSchedule.setDeparturePlaceId(new City(flightScheduleDTO.getDeparturePlaceId()));
        flightSchedule.setDestinationPlaceId(new City(flightScheduleDTO.getDestinationPlaceId()));
        flightSchedule.setScheduledStartDate(flightScheduleDTO.getScheduledStartDate());
        flightSchedule.setScheduledEndDate(flightScheduleDTO.getScheduledEndDate());
        flightSchedule.setIsActive(1);
        return flightScheduleRepository.save(flightSchedule);
    }

    public void addFlightSeats(String seatClause, int seatCount, Flight flight, int isBusinessSeat){
        //int businessSeatCount = flightDTO.getBusinessSeats();
        int seatNumber = 1;
        while( seatCount > 0 ){
            FlightSeats flightSeat = new FlightSeats();
            flightSeat.setFlight(flight);
            flightSeat.setFlightSeatNumber(seatClause+(seatNumber++));
            flightSeat.setIsBusinessSeat(isBusinessSeat);
            seatCount--;
            flightSeatRepository.save(flightSeat);
        }

    }

    public List<FlightSchedule> getFlightSchedules(){
        return flightScheduleRepository.findAll();
    }

    public String blockFlight(int flightId) throws FlightNotFoundException, AddressException {
        int blockedFlights = flightRepository.blockFlight(flightId);
        if(blockedFlights != 0){
            List<String> notifiedUsers = flightRepository.getNotifiedUser(flightId);
            for(String user: notifiedUsers){
                String bodyOfTheContent = "Dear "+ user + ", \n \n Your Flight is blocked due to some emergency flight services, Please book another flight. \n We regret for the inconvenience caused !!! ";
                emailSenderService.sendEMail(user, bodyOfTheContent, "Imp !-  Fight cancelled Due to Emergency flight service" );
            }
            return "Flight Blocked Successfully";
        }
        throw new FlightNotFoundException("Flight Not Exist");
    }

    public List<FlightSeats> getListOfFlightSeats(int flightScheduleId){
        return flightRepository.getFlightSeatsByFlightSchedules(flightScheduleId);

    }

    public Flight getFlightById(int flightId){
        Optional flight = flightRepository.findById(flightId);
        return (Flight)flight.get();
    }

    public String unBlockFlight(int flightId) throws FlightNotFoundException {
        int blockedFlights = flightRepository.unBlockFlight(flightId);
        if(blockedFlights != 0){
            return "Flight Blocked Successfully";
        }
        throw new FlightNotFoundException("Flight Not Exist");
    }

    public String blockFlightSchedule(int flightScheduleId){
        int flightScheduleBlock = flightScheduleRepository.blockFlightSchedule(flightScheduleId);
        if(flightScheduleBlock != 0){
            return "Schedule Blocked Successfully";
        }
        return "Schedule Block Failed";
    }

    public String unBlockFlightSchedule(int flightScheduleId){
        int flightScheduleBlock = flightScheduleRepository.unBlockFlightSchedule(flightScheduleId);
        if(flightScheduleBlock != 0){
            return "Schedule UnBlocked Successfully";
        }
        return "Schedule UnBlock Failed";
    }
}
