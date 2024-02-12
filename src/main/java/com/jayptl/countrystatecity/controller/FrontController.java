package com.jayptl.countrystatecity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/jpa")
public class FrontController {
    
    @GetMapping("/")
    public ModelAndView returnIndex() {

        return new ModelAndView("index");
    }
    

}
