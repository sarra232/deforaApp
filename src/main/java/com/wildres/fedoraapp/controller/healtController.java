package com.wildres.fedoraapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/healt")
public class healtController {

    @GetMapping
    public ResponseEntity<String> getStatus(){
        return ResponseEntity.ok("Status ok!!!");
    }
}
