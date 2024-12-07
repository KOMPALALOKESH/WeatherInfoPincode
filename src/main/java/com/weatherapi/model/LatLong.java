package com.weatherapi.model;

public class LatLong {
	private String latitude;
	private String longitude;

	public LatLong(double latitude, double longitude) {
		this.latitude = String.valueOf(latitude);
		this.longitude = String.valueOf(longitude);
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
}
