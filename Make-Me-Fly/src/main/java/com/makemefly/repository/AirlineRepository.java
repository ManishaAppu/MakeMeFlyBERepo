package com.makemefly.repository;

import com.makemefly.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    @Query(value = "from Airline a where a.isActive = 1")
    public List<Airline> getAllAirlines();

    @Transactional
    @Modifying
    @Query(value = "update Airline set isActive = 0 where airlineId = :airlineId")
    public int blockAirline(@Param("airlineId") int airlineId);

}
