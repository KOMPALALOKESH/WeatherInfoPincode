package com.weatherapi.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.exception.CustomException.WeatherApiException;
import com.weatherapi.model.LatLong;

@Component
public class WeatherApiUtil {
    
    @Value("${weather.api.key}")
    private String apiKey;
    
    @Value("${weather.api.url}")
    private String apiUrl;
    
    private final RestTemplate restTemplate = new RestTemplate();

    public String getWeatherData(LatLong latLong, LocalDate forDate) {
        try {
            String url = String.format(apiUrl, latLong.getLatitude(), latLong.getLongitude(), forDate, apiKey);
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new WeatherApiException("Error getting weather data: " + e.getMessage());
        }
    }
}
