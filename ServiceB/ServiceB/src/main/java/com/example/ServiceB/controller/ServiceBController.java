package com.example.ServiceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/b")
public class ServiceBController {

    private final RestTemplate restTemplate;

    public ServiceBController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String serviceB(){
        return "Service B is Called from Service A";
    }
}
