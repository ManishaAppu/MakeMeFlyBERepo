package com.makemefly.dto;


import lombok.*;
import org.springframework.context.annotation.ComponentScan;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirlineDTO {

    private int airlineId;
    private String airlineName;
    private String iaia;
    private int isActive;

}
