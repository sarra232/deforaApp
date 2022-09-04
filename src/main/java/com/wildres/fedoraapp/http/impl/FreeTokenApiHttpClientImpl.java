package com.wildres.fedoraapp.http.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildres.fedoraapp.http.FreeTokenAphttpClient;
import com.wildres.fedoraapp.model.City;
import com.wildres.fedoraapp.model.FreeTokenApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
public class FreeTokenApiHttpClientImpl implements FreeTokenAphttpClient {

    Logger logger = LoggerFactory.getLogger(FreeTokenApiHttpClientImpl.class);

    @Autowired
    private Environment env;

    @Override
    public FreeTokenApi getToken() {
        this.logger.info("Into Impl http!");

        String path = this.env.getProperty("token-path");
        String apiToken = this.env.getProperty("api-token");
        String emailUser = this.env.getProperty("user-email");
        this.logger.info("Path: {}, toekn: {} y email: {}", path, apiToken, emailUser);
        FreeTokenApi tokenResponse = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .setHeader(HttpHeaders.ACCEPT, "application/json")
                .setHeader("api-token", apiToken)
                .setHeader("user-email", emailUser)
                .GET()
                .build();
        this.logger.info("Request http! - {}", request);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // parse JSON
            ObjectMapper mapper = new ObjectMapper();
            tokenResponse = mapper.readValue(response.body(), new TypeReference<FreeTokenApi>() {});
            this.logger.info("Reponse http! - {}", response);

        } catch (IOException | InterruptedException e) {
            this.logger.error("Error http! - {}", e);
            e.printStackTrace();
        }
        return tokenResponse;
    }

}
