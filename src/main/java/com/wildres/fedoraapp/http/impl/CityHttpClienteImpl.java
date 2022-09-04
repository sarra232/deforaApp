package com.wildres.fedoraapp.http.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildres.fedoraapp.http.CityHttpClient;
import com.wildres.fedoraapp.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Component
public class CityHttpClienteImpl implements CityHttpClient {
    Logger logger = LoggerFactory.getLogger(CityHttpClienteImpl.class);

    @Autowired
    private Environment env;
    @Override
    public ArrayList<City> getCity(String token) {
        this.logger.info("Into Impl http!");

        String path = this.env.getProperty("city-path");;
        ArrayList<City> cities = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .GET()
                .build();
        this.logger.info("Request http! - {}", request);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // parse JSON
            ObjectMapper mapper = new ObjectMapper();
            cities = mapper.readValue(response.body(), new TypeReference<ArrayList<City>>() {});
            this.logger.info("Reponse http! - {}", response);

        } catch (IOException | InterruptedException e) {
            this.logger.error("Error http! - {}", e);
            e.printStackTrace();
        }
        return cities;
    }
}
