package com.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.weatherapi.model.WeatherRequest;
import com.weatherapi.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public ResponseEntity<?> getWeatherInfo(@RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weatherService.getWeatherData(request));
    }

        
}

