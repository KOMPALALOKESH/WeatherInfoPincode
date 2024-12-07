package com.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapi.dto.*;
import com.weatherapi.model.*;
import com.weatherapi.repository.impl.WeatherRepository;
import com.weatherapi.util.*;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private GeoCodingUtil geoCodingUtil;

    @Autowired
    private WeatherApiUtil weatherApiUtil;

    public WeatherResponseDto getWeatherData(WeatherRequest request) {
        WeatherInfo existingInfo = weatherRepository.findByPincodeAndDate(request.getPincode(), request.getForDate());
        
        if (existingInfo != null) {
            return new WeatherResponseDto(existingInfo);
        }

        LatLong latLong = geoCodingUtil.getLatLong(request.getPincode());
        String weatherData = weatherApiUtil.getWeatherData(latLong, request.getForDate());

        WeatherInfo weatherInfo = new WeatherInfo(request.getPincode(), latLong.getLatitude(), latLong.getLongitude(), request.getForDate(), weatherData);
        weatherRepository.save(weatherInfo);

        return new WeatherResponseDto(weatherInfo);
    }
}

