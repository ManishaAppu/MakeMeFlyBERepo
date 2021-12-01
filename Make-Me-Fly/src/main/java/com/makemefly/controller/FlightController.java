package com.makemefly.controller;

import com.makemefly.Exception.FlightNotFoundException;
import com.makemefly.dto.FlightDTO;
import com.makemefly.dto.FlightScheduleDTO;
import com.makemefly.dto.FlightScheduleId;
import com.makemefly.entity.Flight;
import com.makemefly.entity.FlightSchedule;
import com.makemefly.entity.FlightSeats;
import com.makemefly.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/addFlight")
    public Flight addFlight(@RequestBody FlightDTO flight){
        return flightService.addFlight(flight);
    }

    @GetMapping("/getAllFlight")
    public List<Flight> getAllFlight(){
            return flightService.getAllFlight();
    }

    @PostMapping("/scheduleFlight")
    public FlightSchedule scheduleFlight(@RequestBody FlightScheduleDTO flightScheduleDTO){
        return flightService.scheduleFlight(flightScheduleDTO);
    }

//    @CrossOrigin(origins="http://localhost:4200/")
    @GetMapping("/getSchedules")
    public List<FlightSchedule> getFlightSchedules(){
        return flightService.getFlightSchedules();
    }

//    @CrossOrigin(origins="http://localhost:4200/")
    @PutMapping(value = "/blockFlight/{flightId}")
    public ResponseEntity<String> blockFlight(@PathVariable int flightId) throws FlightNotFoundException, AddressException {
        flightService.blockFlight(flightId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getFlightSeats/{flightScheduleId}")
    public List<FlightSeats> getListOfFlight(@PathVariable int flightScheduleId){
        return flightService.getListOfFlightSeats(flightScheduleId);
    }

    @GetMapping("/getFlight/{flightId}")
    public Flight getFlightById(@PathVariable int flightId){
        return flightService.getFlightById(flightId);
    }

    @PutMapping(value = "/unBlockFlight/{flightId}")
    public ResponseEntity<String> unBlockFlight(@PathVariable int flightId) throws FlightNotFoundException {
        flightService.unBlockFlight(flightId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/blockFlightSchedule/{flightScheduleId}")
    public ResponseEntity<String> blockFlightSchedule(@PathVariable int flightScheduleId){
        flightService.blockFlightSchedule(flightScheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/unBlockFlightSchedule/{flightScheduleId}")
    public ResponseEntity<String> unBlockFlightSchedule(@PathVariable int flightScheduleId){
        flightService.unBlockFlightSchedule(flightScheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
