package com.makemefly.controller;

import com.makemefly.entity.City;
import com.makemefly.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/getAllCity")
    public List<City> getAll(){
        return cityService.getAllCity();
    }

}
