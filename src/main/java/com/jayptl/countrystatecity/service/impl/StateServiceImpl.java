package com.jayptl.countrystatecity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayptl.countrystatecity.dto.StateDto;
import com.jayptl.countrystatecity.exception.EntityNotFoundException;
import com.jayptl.countrystatecity.model.State;
import com.jayptl.countrystatecity.repository.CountryRepository;
import com.jayptl.countrystatecity.repository.StateRepository;
import com.jayptl.countrystatecity.service.StateService;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public State getStateById(long id) {
        return stateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("State with id " + id + " not exists"));
    }

    @Override
    public List<State> getStatesByCountryId(long countryId) {
        return stateRepository.getStatesByCountryId(countryId);
    }

    @Override
    public State addNewState(StateDto stateDto, long countryId) {
        if (stateRepository.existsById(stateDto.getId())) {
            updateState(stateDto, countryId);
        }
        State state = new State();
        state.setStateName(stateDto.getStateName());
        state.setCountry(countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country with id " + countryId + " not exists")));
        return stateRepository.save(state);
    }

    @Override
    public State updateState(StateDto stateDto, long countryId) {
        State state = new State();
        if (state.getStateName() != null && !state.getStateName().isEmpty()) {
            state.setStateName(stateDto.getStateName());
        }
        state.setCountry(countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country with id " + countryId + " not exists")));
        return stateRepository.save(state);
    }

    @Override
    public String deleteStateById(long id) {
        if (stateRepository.existsById(id)) {
            stateRepository.deleteById(id);
            return "Deleted";
        }
        throw new EntityNotFoundException("State with id " + id + " not exists");
    }

}
