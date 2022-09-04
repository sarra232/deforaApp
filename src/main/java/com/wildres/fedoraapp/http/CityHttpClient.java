package com.wildres.fedoraapp.http;

import com.wildres.fedoraapp.model.City;

import java.util.ArrayList;

public interface CityHttpClient {
    public ArrayList<City> getCity(String token);

}
