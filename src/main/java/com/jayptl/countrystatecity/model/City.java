package com.jayptl.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnore
    private State state;

}
