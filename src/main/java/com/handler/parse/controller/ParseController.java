package com.handler.parse.controller;

import com.handler.parse.dto.ParseRequest;
import com.handler.parse.dto.ParseResponse;
import com.handler.parse.service.ParseService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParseController {

    private final ParseService parseService;

    @PostMapping("api/parse")
    public ResponseEntity<ParseResponse> parse(@RequestBody @Valid ParseRequest request) {
        final ParseResponse response = parseService.parse(request);
        return ResponseEntity.ok(response);
    }

}
