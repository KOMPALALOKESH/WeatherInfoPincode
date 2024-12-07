package com.weatherapi.dto;

import com.weatherapi.model.WeatherInfo;

public class WeatherResponseDto {
	private String pincode;
	private String date;
	private String weatherData;

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(String weatherData) {
		this.weatherData = weatherData;
	}

	public WeatherResponseDto(WeatherInfo existingInfo) {
		if (existingInfo != null) {
			this.pincode = existingInfo.getPincode();
			this.date = existingInfo.getDate().toString();
			this.weatherData = existingInfo.getWeatherData();
		}
	}

}
