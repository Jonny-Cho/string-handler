package com.handler.parse.service;

import com.handler.parse.dto.ParseRequest;
import com.handler.parse.dto.ParseResponse;
import com.handler.parse.util.UrlConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParseService {

    private final UrlConnector urlConnector;

    public ParseResponse parse(final ParseRequest request) {
        final String html = urlConnector.getHtml(request.getUrl());
        return null;
    }
}
