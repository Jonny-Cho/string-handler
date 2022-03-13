package com.handler.parse.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExposureTypeTest {

    @DisplayName("REMOVE_HTML 타입인 경우 태그를 삭제한다")
    @Test
    void removeHtml() {
        final String result = ExposureType.REMOVE_HTML.getExposedHtml("<div>abc</div>");
        assertThat(result).isEqualTo("abc");
    }

    @DisplayName("ALL_TEXT 타입인 경우 모든 텍스트를 가져온다")
    @Test
    void allText() {
        final String result = ExposureType.ALL_TEXT.getExposedHtml("<div>abc</div>");
        assertThat(result).isEqualTo("<div>abc</div>");
    }

}
