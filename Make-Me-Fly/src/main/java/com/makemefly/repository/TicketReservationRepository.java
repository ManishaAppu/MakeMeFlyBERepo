package com.makemefly.repository;

import com.makemefly.entity.TicketBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketReservationRepository extends JpaRepository<TicketBookingDetails, Integer> {

    @Query(value = "from TicketBookingDetails a where a.isActive = 1 and a.ticketBookingId = :ticketBookingId")
    public TicketBookingDetails findByTicketBookingId(@Param("ticketBookingId") int ticketBookingId);

    @Transactional
    @Modifying
    @Query(value = "update TicketBookingDetails set isActive = 0 where ticketBookingId = :ticketId")
    public int cancelTicket(@Param("ticketId") int ticketId);


}
