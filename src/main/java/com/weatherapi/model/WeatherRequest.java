package com.weatherapi.model;

import java.time.LocalDate;

public class WeatherRequest {
	private String pincode;
	private LocalDate forDate;

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public LocalDate getForDate() {
		return forDate;
	}

	public void setForDate(LocalDate forDate) {
		this.forDate = forDate;
	}
}
