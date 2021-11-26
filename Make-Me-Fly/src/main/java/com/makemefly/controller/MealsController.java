package com.makemefly.controller;

import com.makemefly.entity.Meal;
import com.makemefly.service.MealsServices;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class MealsController {

    @Autowired
    MealsServices mealsServices;

    @GetMapping("getMealType")
    List<Meal> getAllMeals(){
       return mealsServices.getAllMealsType();
    }
}
