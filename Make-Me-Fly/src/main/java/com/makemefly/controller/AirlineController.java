package com.makemefly.controller;

import com.makemefly.Exception.AirlineNotFoundException;
import com.makemefly.dto.AirlineDTO;
import com.makemefly.dto.MessageDTO;
import com.makemefly.entity.Airline;
import com.makemefly.service.AirlineService;
import com.makemefly.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class AirlineController {

//    private KafkaTemplate kafkaTemplate;

//    public AirlineController(KafkaTemplate kafkaTemplate){
//        this.kafkaTemplate = kafkaTemplate;
//    }

    private static final String TOPIC = "kafka_topic";


    @Autowired
    AirlineService airlineService;

    @Autowired
    EmailSenderService emailSenderService;

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

    @PutMapping(value = "/blockAirline/{airlineId}")
    public ResponseEntity<String> blockAirline(@PathVariable int airlineId) throws AirlineNotFoundException {
        String blockedAirline =  airlineService.blockAirline(airlineId);
        MessageDTO msg = new MessageDTO(blockedAirline, airlineId);
      //  kafkaTemplate.send(TOPIC, msg);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/unBlockAirline/{airlineId}")
    public ResponseEntity<String> unBlockAirline(@PathVariable int airlineId) throws AirlineNotFoundException {
        String blockedAirline =  airlineService.unBlockAirline(airlineId);
        MessageDTO msg = new MessageDTO(blockedAirline, airlineId);
        //  kafkaTemplate.send(TOPIC, msg);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/getAirline/{airlineId}")
    public Airline getAirlineById(@PathVariable int airlineId){
        return airlineService.getAirlineById(airlineId);
    }

    @PostMapping(value="sendMail")
    public String sendMail() throws AddressException {
        emailSenderService.sendEMail("damaris.runolfsdottir2@ethereal.email", "Test", "Mail sub");
        return "Success";
    }

}
