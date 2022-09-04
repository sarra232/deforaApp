package com.wildres.fedoraapp.services.impl;

import com.wildres.fedoraapp.http.FreeTokenAphttpClient;
import com.wildres.fedoraapp.model.FreeTokenApi;
import com.wildres.fedoraapp.services.FreeTokenApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeTokenApiServicesImpl implements FreeTokenApiServices {

    @Autowired
    private FreeTokenAphttpClient freeTokenAphttpClient;

    @Override
    public FreeTokenApi getToken() {
        return this.freeTokenAphttpClient.getToken();
    }
}
