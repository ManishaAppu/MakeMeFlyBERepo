package com.makemefly.repository;

import com.makemefly.entity.TicketBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketReservationRepository extends JpaRepository<TicketBookingDetails, Integer> {

    public TicketBookingDetails findByTicketBookingId(int ticketBookingId);

}
