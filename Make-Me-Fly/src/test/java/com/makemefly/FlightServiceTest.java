package com.makemefly;

import com.makemefly.Exception.AirlineNotFoundException;
import com.makemefly.Exception.FlightNotFoundException;
import com.makemefly.dto.AirlineDTO;
import com.makemefly.dto.FlightDTO;
import com.makemefly.entity.Airline;
import com.makemefly.entity.Flight;
import com.makemefly.service.AirlineService;
import com.makemefly.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.internet.AddressException;

@SpringBootTest
public class FlightServiceTest {

    @Mock
    FlightService flightService;

    @Test
    public void testBlockFlight() throws FlightNotFoundException, AddressException {
        Mockito.doThrow(new FlightNotFoundException("Flight Not Exist")).when(flightService).blockFlight(ArgumentMatchers.anyInt());
        Assertions.assertThrows(FlightNotFoundException.class, () -> {
            flightService.blockFlight(ArgumentMatchers.anyInt());
        });
    }

    @Test
    public void testSuccessfulBlockFlight() throws FlightNotFoundException, AddressException {
        Mockito.when(flightService.blockFlight(ArgumentMatchers.anyInt())).thenReturn("Flight Blocked Successfully");
        Assertions.assertEquals("Flight Blocked Successfully", flightService.blockFlight(ArgumentMatchers.anyInt()));
    }


    @Test
    public void addAirlineTest(){
        Mockito.when(flightService.addFlight(new FlightDTO())).thenReturn(new Flight( 234 ));
        Flight flight = flightService.addFlight(new FlightDTO());
        Assertions.assertNotNull(flight);
    }
}
