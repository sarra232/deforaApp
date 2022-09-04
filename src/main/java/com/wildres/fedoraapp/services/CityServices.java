package com.wildres.fedoraapp.services;

import com.wildres.fedoraapp.model.City;

import java.util.ArrayList;

public interface CityServices {

    public ArrayList<City> getCities(String token);
}
