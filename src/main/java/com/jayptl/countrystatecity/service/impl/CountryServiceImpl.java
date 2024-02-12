package com.jayptl.countrystatecity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.countrystatecity.exception.EntityNotFoundException;
import com.jayptl.countrystatecity.model.Country;
import com.jayptl.countrystatecity.repository.CountryRepository;
import com.jayptl.countrystatecity.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

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
            countryRepository.deleteById(id);
            return "Deleted";
        }
        throw new EntityNotFoundException("Country with id " + id + " not exists");
    }

}
