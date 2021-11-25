package com.makemefly.repository;

import com.makemefly.dto.AvailableFlightsDTO;
import com.makemefly.entity.Flight;
import com.makemefly.entity.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {
    @Query(value = "SELECT F.businessSeatCost FROM FlightSchedule FS inner join Flight F on F.flightId = FS.flight.flightId where FS.flightScheduleId = :id")
    public double getBusinessSeatCostByFlightScheduleId(@Param("id") int id);

    @Query(value = "SELECT F.nonBusinessSeatCost FROM FlightSchedule FS inner join Flight F on F.flightId = FS.flight.flightId where FS.flightScheduleId = :id")
    public double getNonBusinessSeatCostByFlightScheduleId(@Param("id") int id);

    @Query(value = "SELECT new com.makemefly.dto.AvailableFlightsDTO(fs.flightScheduleId, f.flightId, f.flightName, f.businessSeatCost, f.nonBusinessSeatCost," +
            " fs.departurePlaceId.cityId as departurePlaceId, fs.destinationPlaceId.cityId as arrivalPlaceId, fs.departureTime, fs.arrivalTime," +
            " c.cityName as departurePlace, ct.cityName as arrivalPlace ) from Flight f inner join FlightSchedule fs on f.flightId = fs.flight.flightId" +
            " inner join City c on fs.departurePlaceId.cityId = c.cityId " +
            " inner join City ct on fs.destinationPlaceId.cityId = ct.cityId " +
            " where fs.departurePlaceId.cityId = :departurePlaceId and fs.destinationPlaceId.cityId = :arrivalPlaceId and" +
            " (:travelDate  between fs.scheduledStartDate and fs.scheduledEndDate) and f.isActive = 1")
    public List<AvailableFlightsDTO> getListOfAvailableFlights(@Param("departurePlaceId")int departurePlaceId, @Param("arrivalPlaceId") int arrivalPlaceId,
                                                                @Param("travelDate") LocalDateTime travelDate);


    @Transactional
    @Modifying
    @Query(value = "update FlightSchedule set isActive = 0 where flightScheduleId = :flightScheduleId")
    public int blockFlightSchedule(@Param("flightScheduleId") int flightScheduleId);


    @Transactional
    @Modifying
    @Query(value = "update FlightSchedule set isActive = 1 where flightScheduleId = :flightScheduleId")
    public int unBlockFlightSchedule(@Param("flightScheduleId") int flightScheduleId);




}
