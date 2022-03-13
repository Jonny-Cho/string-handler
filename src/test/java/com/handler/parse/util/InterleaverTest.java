package com.handler.parse.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InterleaverTest {

    private final Interleaver interleaver = new Interleaver();

    @DisplayName("문자열 두개가 주어질 때 하나씩 교차하여 출력한다. 남은 것은 뒤에 붙인다")
    @ParameterizedTest
    @CsvSource({
        "aaaaaaa, 1111, a1a1a1a1aaa",
        "AAAAAbbbCCCCcDDdddEeee, 0123456789, A0A1A2A3A4b5b6b7C8C9CCcDDdddEeee",
        "ABbCcD, 0123456789, A0B1b2C3c4D56789",
    })
    void interleaveTest(final String str1, final String str2, final String result) {
        assertThat(interleaver.interleave(str1, str2)).isEqualTo(result);
    }
}
