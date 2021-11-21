package com.makemefly.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleDaysId;
    private String scheduleDay;
    private int isActive;
}
