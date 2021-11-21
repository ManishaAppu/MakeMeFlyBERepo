package com.makemefly.service;

import com.makemefly.dto.PassengerMealDTO;
import com.makemefly.entity.Passenger;
import com.makemefly.entity.Users;
import com.makemefly.repository.PassengerRepository;
import com.makemefly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    public Users saveUser(Users user){
        System.out.println(user.getUserEmail());
        return userRepository.save(user);
    }

    public List<PassengerMealDTO> mealPref(int passengerId){
        System.out.println("PassengerId >>>> " + passengerId);
        return passengerRepository.passengerMeals(passengerId);
    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }
}
