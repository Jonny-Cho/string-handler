package com.handler.parse.error;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error(e.getMessage());

        final List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        final List<CustomError> customErrors = CustomError.from(allErrors);

        return ResponseEntity
            .badRequest()
            .body(new ErrorResponse(customErrors, "E001"));
    }

    @ExceptionHandler(UrlConnectionException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> urlConnectionException(final UrlConnectionException e) {
        log.error(e.getMessage());
        return ResponseEntity
            .badRequest()
            .body(new ErrorResponse("url", e.getMessage(), "E002"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(final HttpMessageNotReadableException e) {
        log.error(e.getMessage());
        return ResponseEntity
            .badRequest()
            .body(new ErrorResponse("exposureType", e.getMessage(), "E003"));
    }

}
