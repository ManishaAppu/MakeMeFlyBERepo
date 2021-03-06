package com.makemefly.service;

import com.makemefly.Exception.AirlineNotFoundException;
import com.makemefly.dto.AirlineDTO;
import com.makemefly.entity.Airline;
import com.makemefly.mapper.AirlineMapper;
import com.makemefly.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirlineMapper airlineMapper;

    public Airline addAirline(AirlineDTO a){
        Airline airline = airlineMapper.mapToAirline(a);
        airline.setIsActive(1);
        return airlineRepository.save(airline);
    }

    public List<Airline> getAirlines(){
        return airlineRepository.findAll();
    }

    public String  blockAirline(int airlineId) throws AirlineNotFoundException {
        int blockedAirline = airlineRepository.blockAirline(airlineId);
        if(blockedAirline != 0){
             return "Blocked the Airline Successfully";
        }else{
            throw new AirlineNotFoundException("Airline Not Exist");
        }
    }

    public String unBlockAirline(int airlineId) throws AirlineNotFoundException {
        int blockedAirline = airlineRepository.unBlockAirline(airlineId);
        if(blockedAirline != 0){
            return "UnBlocked the Airline Successfully";
        }else{
            throw new AirlineNotFoundException("Airline Not Exist");
        }
    }

    public Airline getAirlineById(int airlineId){
        Optional airline = airlineRepository.findById(airlineId);
        return (Airline) airline.get();
    }


}
