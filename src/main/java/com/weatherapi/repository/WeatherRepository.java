package com.weatherapi.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weatherapi.model.WeatherInfo;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherInfo, Long> {
    WeatherInfo findByPincodeAndDate(String pincode, LocalDate date);
}
