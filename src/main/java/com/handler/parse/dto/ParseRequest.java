package com.handler.parse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParseRequest {

    @Schema(description = "url", defaultValue = "https://www.naver.com")
    @Pattern(regexp = "(http)s?:\\/\\/(www\\.)?[a-zA-Z0-9@:%._\\+~#=]+\\.[a-zA-Z0-9@:%._\\/+-~#=?]+", message = "url 형식이 아닙니다.")
    private final String url;

    @Schema(description = "노출유형", defaultValue = "REMOVE_HTML")
    private final ExposureType exposureType;

    @Schema(description = "출력묶음단위", defaultValue = "10")
    @Min(value = 1, message = "1이상의 수를 입력해주세요.")
    private final Integer unitCount;
}
