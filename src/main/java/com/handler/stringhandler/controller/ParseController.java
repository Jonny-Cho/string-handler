package com.handler.stringhandler.controller;

import com.handler.stringhandler.dto.ParseRequest;
import com.handler.stringhandler.dto.ParseResponse;
import com.handler.stringhandler.service.ParseService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
