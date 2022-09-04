package com.wildres.fedoraapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

public class FreeTokenApi implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("auth_token")
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
