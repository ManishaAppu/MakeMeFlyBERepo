package com.makemefly;

import com.makemefly.Exception.TicketNotFoundException;
import com.makemefly.repository.TicketReservationRepository;
import com.makemefly.service.TicketReservationService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.regex.Matcher;

@SpringBootTest
public class TicketReservationSerivceTest {

    @Mock
    TicketReservationService ticketReservationService;

    @Test
    public void testTicketNotFoundException() throws TicketNotFoundException{
        Mockito.when(ticketReservationService.getTicketsByTicketId(ArgumentMatchers.anyInt())).thenThrow(new TicketNotFoundException(" Ticket Not Found for this ticket Id "));
        Assertions.assertThrows(TicketNotFoundException.class, ()->{ ticketReservationService.getTicketsByTicketId(ArgumentMatchers.anyInt()); });
    }

    @Test
    public void test() throws TicketNotFoundException{
        Mockito.when(ticketReservationService.getTicketsByTicketId(ArgumentMatchers.anyInt())).thenThrow(new TicketNotFoundException(" Ticket Not Found for this ticket Id "));
        Assertions.assertThrows(TicketNotFoundException.class, ()->{ ticketReservationService.getTicketsByTicketId(ArgumentMatchers.anyInt()); });
    }

}
