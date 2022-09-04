package com.wildres.fedoraapp.controller;

import com.wildres.fedoraapp.model.City;
import com.wildres.fedoraapp.services.CityServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/city")
public class CityController {
    Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityServices cityServices;

    @GetMapping
    public ResponseEntity<ArrayList<City>> getCities(@RequestHeader("Bearer-token")String token){
        logger.info("Init getCities {}", token);
        return ResponseEntity.ok(cityServices.getCities(token));
    }
}
