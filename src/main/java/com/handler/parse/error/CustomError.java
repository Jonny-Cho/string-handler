package com.handler.parse.error;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Getter
@RequiredArgsConstructor
public class CustomError {
    private final String field;
    private final String message;

    public CustomError(final ObjectError objectError) {
        final FieldError fieldError = (FieldError) objectError;
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }

    public static List<CustomError> from(final List<ObjectError> allErrors) {
        return allErrors.stream()
            .map(CustomError::new)
            .collect(Collectors.toList());
    }

    public static CustomError from(final String field, final String errorMessage) {
        return new CustomError(field, errorMessage);
    }
}
