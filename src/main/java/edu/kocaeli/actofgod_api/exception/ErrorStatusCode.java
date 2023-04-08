package edu.kocaeli.actofgod_api.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorStatusCode {
    LOCATION_NOT_FOUND_BY_ID("Location not found by id!", HttpStatus.NOT_FOUND);


    private final String description;
    private final HttpStatus httpStatus;
}