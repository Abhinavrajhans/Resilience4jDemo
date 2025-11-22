package com.example.ServiceA.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/a")
public class ServiceAController {

    private final RestTemplate restTemplate;

    public ServiceAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String BASE_URL = "http://localhost:8081/";

    private static final String SERVICE_A = "serviceA";

    @GetMapping
    @CircuitBreaker(name=SERVICE_A , fallbackMethod = "serviceAFallback")
    public String serviceA(){

        String url = BASE_URL + "b";
        return restTemplate.getForObject(url , String.class);
    }

    public String serviceAFallback(Exception e){
        return "This is a fallback method for Service A";
    }
}
