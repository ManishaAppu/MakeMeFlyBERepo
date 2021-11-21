package com.makemefly.repository;

import com.makemefly.dto.PassengerMealDTO;
import com.makemefly.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    @Query(value = "SELECT new com.makemefly.dto.PassengerMealDTO(P.passengerId, P.passengerName, M.mealType) " +
            "FROM Passenger P JOIN  Meal M ON M.mealId = P.meal.mealId WHERE P.passengerId = :passengerId")
    public List<PassengerMealDTO> passengerMeals(@Param("passengerId") int passengerId);
}
