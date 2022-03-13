package com.handler.parse.controller;

import com.handler.parse.dto.ParseRequest;
import com.handler.parse.dto.ParseResponse;
import com.handler.parse.service.ParseService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "url data process", description = "URL 파싱후 HTML 데이터 가공")
    @PostMapping("api/parse")
    public ResponseEntity<ParseResponse> parse(@RequestBody @Valid final ParseRequest request) {
        final ParseResponse response = parseService.parse(request);
        return ResponseEntity.ok(response);
    }

}
