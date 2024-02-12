package com.jayptl.countrystatecity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayptl.countrystatecity.dto.ResponseDto;
import com.jayptl.countrystatecity.model.Country;
import com.jayptl.countrystatecity.service.CountryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{countryId}")
    public ResponseDto getCountryById(@PathVariable(name = "countryId") long countryId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        responseDto.setData(countryService.getCountryById(countryId));
        return responseDto;
    }

    @GetMapping()
    public ResponseDto getAllCountrys() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(countryService.getAllCountrys());
        responseDto.setStatus(200);
        responseDto.setMessage("Ok");
        return responseDto;
    }

    @PostMapping()
    public ResponseDto addNewCountry(@RequestBody Country country) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(200);
        responseDto.setData(countryService.addNewCountry(country));
        responseDto.setMessage("Ok");
        return responseDto;
    }

}
