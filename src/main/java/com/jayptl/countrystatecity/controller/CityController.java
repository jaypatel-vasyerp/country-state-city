package com.jayptl.countrystatecity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl.countrystatecity.dto.CityDto;
import com.jayptl.countrystatecity.dto.ResponseDto;
import com.jayptl.countrystatecity.service.CityService;

@RestController
@RequestMapping("api/country/{countryId}/state/{stateId}/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{cityId}")
    public ResponseDto getCityById(@PathVariable(name = "cityId") long cityId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(cityService.getCityById(cityId));
        return responseDto;
    }

    @GetMapping()
    public ResponseDto getCitiesByStateId(@PathVariable(name = "stateId") long stateId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(cityService.getCitiesByStateId(stateId));
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        return responseDto;
    }

    @PostMapping()
    public ResponseDto addNewCity(@RequestBody CityDto city,
            @PathVariable(name = "stateId") long stateId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(cityService.addNewCity(city, stateId));
        return responseDto;
    }

}
