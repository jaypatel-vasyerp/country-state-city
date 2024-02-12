package com.jayptl.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
