package com.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.weatherapi.dto.ErrorResponseDto;
import com.weatherapi.exception.CustomException.WeatherApiException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<ErrorResponseDto> handleWeatherApiException(WeatherApiException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponseDto(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorResponseDto("An unexpected error occurred"));
    }
}
