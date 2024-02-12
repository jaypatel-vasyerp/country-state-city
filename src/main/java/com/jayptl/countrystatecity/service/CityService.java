package com.jayptl.countrystatecity.service;

import java.util.List;

import com.jayptl.countrystatecity.model.City;

public interface CityService {
    
    City getCityById(long id);

    List<City> getCitiesByStateId(long stateId);

}
