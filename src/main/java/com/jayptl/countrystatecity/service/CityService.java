package com.jayptl.countrystatecity.service;

import java.util.List;

import com.jayptl.countrystatecity.dto.CityDto;
import com.jayptl.countrystatecity.model.City;

public interface CityService {

    City getCityById(long id);

    List<City> getCitiesByStateId(long stateId);

    City addNewCity(CityDto city,long stateId);

    City updateCity(CityDto cityDto,long stateId);

    String deleteCityById(long id);

}
