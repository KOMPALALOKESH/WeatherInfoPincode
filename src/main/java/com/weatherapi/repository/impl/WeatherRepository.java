package com.weatherapi.repository.impl;

import com.weatherapi.model.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherInfo, Long> {
	WeatherInfo findByPincodeAndDate(String pincode, LocalDate forDate);
}