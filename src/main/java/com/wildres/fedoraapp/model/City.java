package com.wildres.fedoraapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("country_name")
    private String name;
    @JsonProperty("country_short_name")
    private String shotName;
    @JsonProperty("country_phone_code")
    private String code;
}
