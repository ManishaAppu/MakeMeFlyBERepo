package com.makemefly.entity;

import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meal {


    public Meal(int mealId) {
        this.mealId = mealId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnlyProperty
    private int mealId;
    @ReadOnlyProperty
    private String mealType;

  /*  @ManyToMany
    private List<Flight> flights;*/

}
