package com.handler.parse.service;

import com.handler.parse.dto.OutputUnit;
import com.handler.parse.dto.ParseRequest;
import com.handler.parse.dto.ParseResponse;
import com.handler.parse.util.Arranger;
import com.handler.parse.util.Interleaver;
import com.handler.parse.util.UrlConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParseService {

    private final UrlConnector urlConnector;
    private final Arranger arranger;
    private final Interleaver interleaver;

    public ParseResponse parse(final ParseRequest request) {
        final String html = urlConnector.getHtml(request.getUrl());
        final String exposedHtml = request.getExposureType().getExposedHtml(html);
        final Arranger rearrange = arranger.rearrange(exposedHtml);
        final String interleavedText = interleaver.interleave(rearrange);
        final OutputUnit outputUnit = new OutputUnit(interleavedText, request.getUnitCount());
        return new ParseResponse(outputUnit);
    }
}
