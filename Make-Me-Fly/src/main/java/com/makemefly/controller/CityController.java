package com.makemefly.controller;

import com.makemefly.entity.City;
import com.makemefly.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/getAllCity")
    public List<City> getAll(){
        return cityService.getAllCity();
    }

}
