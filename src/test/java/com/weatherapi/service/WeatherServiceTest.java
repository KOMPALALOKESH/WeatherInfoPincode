package com.weatherapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.weatherapi.dto.WeatherResponseDto;
import com.weatherapi.model.WeatherInfo;
import com.weatherapi.model.WeatherRequest;
import com.weatherapi.repository.WeatherRepository;
import com.weatherapi.util.*;

class WeatherServiceTest {

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private GeoCodingUtil geoCodingUtil;

    @Mock
    private WeatherApiUtil weatherApiUtil;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenCacheHit_returnsCachedData() {
        WeatherRequest request = new WeatherRequest();
        request.setPincode("411014");
        request.setForDate(LocalDate.now());

        WeatherInfo cachedInfo = new WeatherInfo();
        cachedInfo.setPincode("411014");
        cachedInfo.setLatitude("18.5204"); 
        cachedInfo.setLongitude("73.8567");
        cachedInfo.setDate(request.getForDate().toString());
        cachedInfo.setWeatherData("{'temp': 25}");
        
        when(weatherRepository.findByPincodeAndDate(request.getPincode(), request.getForDate()))
            .thenReturn(cachedInfo);

        WeatherResponseDto response = weatherService.getWeatherData(request);

        assertNotNull(response);
        assertEquals("411014", response.getPincode());
        verify(weatherApiUtil, never()).getWeatherData(any(), any());
    }
} 