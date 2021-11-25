package com.makemefly.repository;

import com.makemefly.entity.TicketBookingDetails;
import com.makemefly.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TicketReservationRepository extends JpaRepository<TicketBookingDetails, Integer> {

    @Query(value = "from TicketBookingDetails a where a.ticketBookingId = :ticketBookingId")
    public TicketBookingDetails findByTicketBookingId(@Param("ticketBookingId") int ticketBookingId);

    @Transactional
    @Modifying
    @Query(value = "update TicketBookingDetails set isActive = 0 where ticketBookingId = :ticketId")
    public int cancelTicket(@Param("ticketId") int ticketId);

    @Query(value = "from TicketBookingDetails a where user = :User")
    public List<TicketBookingDetails> findTicketByUserEmail(@Param("User") String userEmail);

    @Query(value = "from TicketBookingDetails a where a.userEmail = :userEmail")
    public List<TicketBookingDetails> findByUserEmail(@Param("userEmail") String userEmail);

}
