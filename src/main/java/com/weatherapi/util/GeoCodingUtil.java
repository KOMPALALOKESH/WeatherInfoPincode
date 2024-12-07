package com.weatherapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.exception.CustomException.WeatherApiException;
import com.weatherapi.model.LatLong;
import com.weatherapi.model.GeocodingResponse;

@Component
public class GeoCodingUtil {
    
    @Value("${geocoding.api.key}")
    private String apiKey;
    
    @Value("${geocoding.api.url}")
    private String apiUrl;
    
    private final RestTemplate restTemplate = new RestTemplate();

    public LatLong getLatLong(String pincode) {
        try {
            String url = String.format(apiUrl, pincode, apiKey);
            GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
            
            if (response == null || response.getResults().isEmpty()) {
                throw new WeatherApiException("Unable to find coordinates for pincode: " + pincode);
            }
            
            return new LatLong(
                response.getResults().get(0).getGeometry().getLocation().getLat(),
                response.getResults().get(0).getGeometry().getLocation().getLng()
            );
        } catch (Exception e) {
            throw new WeatherApiException("Error getting coordinates for pincode: " + e.getMessage());
        }
    }
}
