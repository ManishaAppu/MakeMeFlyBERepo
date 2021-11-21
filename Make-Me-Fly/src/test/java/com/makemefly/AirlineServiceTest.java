package com.makemefly;

import com.makemefly.Exception.AirlineNotFoundException;
import com.makemefly.dto.AirlineDTO;
import com.makemefly.entity.Airline;
import com.makemefly.service.AirlineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AirlineServiceTest {

    @Mock
    AirlineService airlineService;

    @Test
    public void testBlockAirline() throws AirlineNotFoundException {
        Mockito.doThrow(new AirlineNotFoundException(" Airline Not Exist")).when(airlineService).blockAirline(ArgumentMatchers.anyInt());
        Assertions.assertThrows(AirlineNotFoundException.class, () -> {
            airlineService.blockAirline(ArgumentMatchers.anyInt());
        });
    }

    @Test
    public void testSuccessfulBlockAirline() throws AirlineNotFoundException {
        Mockito.when(airlineService.blockAirline(ArgumentMatchers.anyInt())).thenReturn("Blocked the Airline Successfully");
        Assertions.assertEquals("Blocked the Airline Successfully", airlineService.blockAirline(ArgumentMatchers.anyInt()));
    }


    @Test
    public void addAirlineTest(){
        Mockito.when(airlineService.addAirline(new AirlineDTO())).thenReturn(new Airline( 234,"Decaan", "DC", 1 ));
        Airline airlineAssert = airlineService.addAirline(new AirlineDTO());
        Assertions.assertNotNull(airlineAssert);
    }
}