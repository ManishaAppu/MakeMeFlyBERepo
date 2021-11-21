package com.makemefly.controller;

import com.makemefly.dto.PassengerMealDTO;
import com.makemefly.entity.Passenger;
import com.makemefly.entity.Users;
import com.makemefly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Users saveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }

   @GetMapping("/getMealPref/{passengerId}")
    public List<PassengerMealDTO> getMealPrefs( @PathVariable int passengerId){
        return userService.mealPref(passengerId);
    }

    @GetMapping("/getAllPassengers")
    public List<Passenger> getAllPassengers(){
        return userService.getAllPassengers();
    }

}