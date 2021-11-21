package com.makemefly.repository;

import com.makemefly.entity.FlightSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightSeatRepository extends JpaRepository<FlightSeats, Integer> {
}
