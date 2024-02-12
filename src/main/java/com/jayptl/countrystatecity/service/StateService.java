package com.jayptl.countrystatecity.service;

import java.util.List;

import com.jayptl.countrystatecity.dto.StateDto;
import com.jayptl.countrystatecity.model.State;

public interface StateService {

    State getStateById(long id);

    List<State> getStatesByCountryId(long countryId);

    State addNewState(StateDto state, long countryId);

    State updateState(StateDto stateDto, long countryId);

    String deleteStateById(long id);

}
