package com.makemefly.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline {

    public Airline(String airlineName, String iaia, int isActive) {
        this.airlineName = airlineName;
        this.iaia = iaia;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airlineId;
    private String airlineName;
    private String iaia;
    private int isActive;

  /*  @OneToMany(mappedBy = "airline")
    @Transient
   // @JsonBackReference
//    @JsonIgnore
    private List<Flight> flights;*/

}
