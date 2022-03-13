package com.handler.parse.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParseRequest {
    private final String url;
    private final String exposureType;
    private final Integer unitCount;
}
