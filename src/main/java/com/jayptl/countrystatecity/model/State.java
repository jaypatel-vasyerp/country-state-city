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
public class State {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "state_name")
    private String stateName;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;
}
