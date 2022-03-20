package com.handler.parse.error;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Getter
@RequiredArgsConstructor
public class CustomFieldError {
    private final String field;
    private final String message;

    public CustomFieldError(final FieldError fieldError) {
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }

    public static List<CustomFieldError> from(final List<FieldError> allErrors) {
        return allErrors.stream()
            .map(CustomFieldError::new)
            .collect(Collectors.toList());
    }

    public static CustomFieldError from(final String field, final String errorMessage) {
        return new CustomFieldError(field, errorMessage);
    }
}
