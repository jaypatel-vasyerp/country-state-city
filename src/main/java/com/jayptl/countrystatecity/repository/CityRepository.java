package com.jayptl.countrystatecity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayptl.countrystatecity.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> getCitysByStateId(long stateId);

}
