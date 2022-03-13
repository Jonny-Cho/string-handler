package com.handler.stringhandler.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParseRequest {
    private final String url;
    private final String exposureType;
    private final Integer unitCount;
}
