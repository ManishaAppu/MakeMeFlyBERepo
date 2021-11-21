package com.makemefly.controller;

import com.makemefly.Exception.FlightNotFoundException;
import com.makemefly.dto.FlightDTO;
import com.makemefly.dto.FlightScheduleDTO;
import com.makemefly.entity.Flight;
import com.makemefly.entity.FlightSchedule;
import com.makemefly.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
//@CrossOrigin({"http://localhost:4200"})
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

    @GetMapping("/getSchedules")
    public List<FlightSchedule> getFlightSchedules(){
        return flightService.getFlightSchedules();
    }

    @PostMapping(value = "/deleteFlight/{flightId}")
    public String blockFlight(@PathVariable int flightId) throws FlightNotFoundException {
        return flightService.blockFlight(flightId);
    }

}
