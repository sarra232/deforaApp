package com.wildres.fedoraapp.controller;

import com.wildres.fedoraapp.model.City;
import com.wildres.fedoraapp.model.FreeTokenApi;
import com.wildres.fedoraapp.services.CityServices;
import com.wildres.fedoraapp.services.FreeTokenApiServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/freeToken")
public class FreeTokenApiController {
    Logger logger = LoggerFactory.getLogger(FreeTokenApiController.class);

    @Autowired
    private FreeTokenApiServices freeTokenApiServices;

    @GetMapping
    public ResponseEntity<FreeTokenApi> getCities(){
        this.logger.info("Init getCities");
        return ResponseEntity.ok(this.freeTokenApiServices.getToken());
    }
}

