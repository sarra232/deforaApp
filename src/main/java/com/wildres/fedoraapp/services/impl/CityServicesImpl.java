package com.wildres.fedoraapp.services.impl;

import com.wildres.fedoraapp.http.CityHttpClient;
import com.wildres.fedoraapp.http.FreeTokenAphttpClient;
import com.wildres.fedoraapp.model.City;
import com.wildres.fedoraapp.model.FreeTokenApi;
import com.wildres.fedoraapp.services.CityServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CityServicesImpl implements CityServices {
    Logger loguer = LoggerFactory.getLogger(CityServicesImpl.class);
    @Autowired
    private CityHttpClient cityHttpClient;

    @Autowired
    private FreeTokenAphttpClient freeTokenAphttpClient;

    @Override
    public ArrayList<City> getCities(String token) {
        this.loguer.info("Starting services");
        if(!Objects.isNull(token)){
            FreeTokenApi freeTokenApi = this.freeTokenAphttpClient.getToken();
            token = freeTokenApi.getToken();
            this.loguer.info("Finish to consult freeTokenAphttpClient");
        }
        return this.cityHttpClient.getCity(token);
    }
}
