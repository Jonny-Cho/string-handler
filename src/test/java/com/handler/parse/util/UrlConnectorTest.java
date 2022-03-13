package com.handler.parse.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UrlConnectorTest {

    private final UrlConnector urlConnector = new UrlConnector();

    @DisplayName("잘못된 url입력시 IllegalArgumentException이 발생한다.")
    @Test
    void urlFailTest() {
        assertThatThrownBy(() -> urlConnector.getHtml("wrong.url.ccc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("url입력시 html을 가져올 수 있다.")
    @ParameterizedTest
    @CsvSource({"https://www.naver.com, <title>NAVER</title>", "https://www.google.com, <title>Google</title>"})
    void urlSucessTest(final String url, final String title) {
        final String result = urlConnector.getHtml(url);

        assertThat(result.contains(title)).isTrue();
    }

}
