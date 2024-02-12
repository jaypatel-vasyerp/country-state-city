package com.jayptl.countrystatecity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.countrystatecity.exception.EntityNotFoundException;
import com.jayptl.countrystatecity.model.City;
import com.jayptl.countrystatecity.repository.CityRepository;
import com.jayptl.countrystatecity.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCityById(long id) {
        return cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("City with id "+ id +" not exists"));
    }

    @Override
    public List<City> getCitiesByStateId(long stateId) {
        return cityRepository.getCitysByStateId(stateId);
    }

}