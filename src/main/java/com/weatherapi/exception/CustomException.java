package com.weatherapi.exception;

public class CustomException {
    public static class WeatherApiException extends RuntimeException {
        public WeatherApiException(String message) {
            super(message);
        }
    }

    public String getMessage() {
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
}
