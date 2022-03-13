package com.handler.parse.dto;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExposureType {
    REMOVE_HTML(str -> str.replaceAll(Constants.REMOVE_TAG_PATTERN, Constants.EMPTY)),
    ALL_TEXT(str -> str);

    private final Function<String, String> function;

    public String getExposedHtml(final String str) {
        return function.apply(str);
    }

    private static class Constants {
        private static final String REMOVE_TAG_PATTERN = "<[^>]*>";
        private static final String EMPTY = "";
    }
}
