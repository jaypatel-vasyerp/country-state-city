package com.jayptl.countrystatecity.service;

import java.util.List;

import com.jayptl.countrystatecity.model.Country;

public interface CountryService {
    
    Country getCountryById(long id);

    List<Country> getAllCountrys();

}
