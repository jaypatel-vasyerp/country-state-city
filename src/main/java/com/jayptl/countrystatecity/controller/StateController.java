package com.jayptl.countrystatecity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl.countrystatecity.dto.ResponseDto;
import com.jayptl.countrystatecity.dto.StateDto;
import com.jayptl.countrystatecity.service.StateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/country/{countryId}/state")
public class StateController {
    
    @Autowired
    private StateService stateService;

    @GetMapping("/{stateId}")
    public ResponseDto getStateById(@PathVariable(name = "stateId") long stateId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(stateService.getStateById(stateId));
        return responseDto;
    }    

    @GetMapping()
    public ResponseDto getStatesByCountryId(@PathVariable(name = "countryId") long countryId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(stateService.getStatesByCountryId(countryId));
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        return responseDto;
    }

    // add & update
    @PostMapping()
    public ResponseDto addNewState(@RequestBody StateDto stateDto, @PathVariable(name = "countryId") long countryId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(stateService.addNewState(stateDto, countryId));
        return responseDto;
    }

    @DeleteMapping("/{stateId}")
    public ResponseDto deleteStateId(@PathVariable(name = "stateId") long stateId){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(stateService.deleteStateById(stateId));

        return responseDto;
    }
    
    
    
}
