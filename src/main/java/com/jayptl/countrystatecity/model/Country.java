package com.jayptl.countrystatecity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
    
    @Id
    private long id;

    @Column(name = "country_name")
    private String countryName;
}
