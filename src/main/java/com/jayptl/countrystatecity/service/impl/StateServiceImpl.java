package com.jayptl.countrystatecity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.countrystatecity.exception.EntityNotFoundException;
import com.jayptl.countrystatecity.model.State;
import com.jayptl.countrystatecity.repository.StateRepository;
import com.jayptl.countrystatecity.service.StateService;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State getStateById(long id) {
        return stateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("State with id " + id + " not exists"));
    }

    @Override
    public List<State> getStatesByCountryId(long countryId) {
        return stateRepository.getStatesByCountryId(countryId);
    }

}
