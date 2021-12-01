package com.makemefly.service;

import com.makemefly.entity.Meal;
import com.makemefly.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealsServices {

    @Autowired
    MealsRepository mealsRepository;

    public List<Meal> getAllMealsType(){
       return mealsRepository.findAll();
    }

}
