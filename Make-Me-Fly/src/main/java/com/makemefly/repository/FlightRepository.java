package com.makemefly.repository;

import com.makemefly.entity.Flight;
import com.makemefly.entity.FlightSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query(value = "from Flight where isActive = 1")
    public List<Flight> getAllFlights();


    @Transactional
    @Modifying
    @Query(value = "update Flight set isActive = 0 where flightId = :flightId")
    public int deleteFlight(@Param("flightId") int flightId);

    @Query("select new com.makemefly.entity.FlightSeats(FS.flightSeatId, FS.flightSeatNumber) from FlightSeats FS inner join FlightSchedule FSC on FSC.flight = FS.flight where FSC.flightScheduleId = :flightScheduleId ")
    public List<FlightSeats> getFlightSeatsByFlightSchedules(@Param("flightScheduleId")int flightScheduleId);


}
