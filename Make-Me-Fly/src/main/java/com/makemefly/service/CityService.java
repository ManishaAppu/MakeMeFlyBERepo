package com.makemefly.service;

import com.makemefly.entity.City;
import com.makemefly.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCity(){
        return cityRepository.findAll();
    }

}
