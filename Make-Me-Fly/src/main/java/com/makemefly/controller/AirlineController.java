package com.makemefly.controller;

import com.makemefly.Exception.AirlineNotFoundException;
import com.makemefly.dto.AirlineDTO;
import com.makemefly.dto.MessageDTO;
import com.makemefly.entity.Airline;
import com.makemefly.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AirlineController {

    private KafkaTemplate kafkaTemplate;

    public AirlineController(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String TOPIC = "kafka_topic";


    @Autowired
    AirlineService airlineService;

    @GetMapping()
    public String welcomeMessage(){
        return "Welcome to Make Me Fly ";
    }

    @PostMapping(value = "/addAirline")
    public Airline addAirline(@RequestBody AirlineDTO airline){
        return airlineService.addAirline(airline);
    }

    @GetMapping(value = "/getAirlines")
    public List<Airline> getAirlines (){
        return airlineService.getAirlines();
    }

    @PostMapping(value = "/deleteAirline/{airlineId}")
    public String deleteAirline(@PathVariable int airlineId) throws AirlineNotFoundException {
        String blockedAirline =  airlineService.blockAirline(airlineId);
        MessageDTO msg = new MessageDTO(blockedAirline, airlineId);
        kafkaTemplate.send(TOPIC, msg);
        return airlineService.blockAirline(airlineId);
    }

}
