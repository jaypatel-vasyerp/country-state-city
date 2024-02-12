package com.jayptl.countrystatecity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayptl.countrystatecity.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> getStatesByCountryId(long countryId);

}
