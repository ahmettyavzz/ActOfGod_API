package edu.kocaeli.actofgod_api.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorStatusCode {
    LOCATION_NOT_FOUND_BY_ID("Konum bulunamadı!", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND_BY_ID("Kullanıcı bulunamadı!", HttpStatus.NOT_FOUND),
    INVALID_EMAIL("Geçersiz E-Mail formatı!", HttpStatus.NOT_FOUND);


    private final String description;
    private final HttpStatus httpStatus;
}