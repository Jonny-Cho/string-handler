package com.handler.parse.error;

import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final List<CustomError> errors;
    private final String errorCode;

    public ErrorResponse(final String field, final String errorMessage, final String errorCode) {
        this.errors = Collections.singletonList(CustomError.from(field, errorMessage));
        this.errorCode = errorCode;
    }
}
