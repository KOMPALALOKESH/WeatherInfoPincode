package com.weatherapi.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String pincode;
    private String latitude;
    private String longitude;
    private String date;
    private String weatherData;
	public WeatherInfo(String pincode2, String latitude2, String longitude2, LocalDate forDate, String weatherData2) {
		this.pincode = pincode2;
		this.latitude = latitude2;
		this.longitude = longitude2;
		this.date = forDate.toString();
		this.weatherData = weatherData2;
	}
	public WeatherInfo() {
    }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}

