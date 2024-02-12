package com.jayptl.countrystatecity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.countrystatecity.exception.EntityNotFoundException;
import com.jayptl.countrystatecity.model.City;
import com.jayptl.countrystatecity.model.Country;
import com.jayptl.countrystatecity.model.State;
import com.jayptl.countrystatecity.repository.CityRepository;
import com.jayptl.countrystatecity.repository.CountryRepository;
import com.jayptl.countrystatecity.repository.StateRepository;
import com.jayptl.countrystatecity.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Country getCountryById(long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country with id " + id + " not exists"));
    }

    @Override
    public List<Country> getAllCountrys() {
        return countryRepository.findAll();
    }

    @Override
    public Country addNewCountry(Country country) {
        if (countryRepository.existsById(country.getId())) {
            updateCountry(country);
        }
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        Country updatedCountry = countryRepository.findById(country.getId()).get();
        if (country.getCountryName() != null && !country.getCountryName().isEmpty()) {
            updatedCountry.setCountryName(country.getCountryName());
        }
        return countryRepository.save(updatedCountry);
    }

    @Override
    public String deleteCountryById(long id) {
        if (countryRepository.existsById(id)) {
            List<State> states = stateRepository.getStatesByCountryId(id);
            for (State state : states) {
                List<City> cities = cityRepository.getCitysByStateId(state.getId());
                cityRepository.deleteAll(cities);
            }
            stateRepository.deleteAll(states);
            countryRepository.deleteById(id);
            return "Deleted";
        }
        throw new EntityNotFoundException("Country with id " + id + " not exists");
    }

}
