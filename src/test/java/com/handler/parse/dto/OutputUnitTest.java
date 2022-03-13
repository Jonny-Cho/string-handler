package com.handler.parse.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputUnitTest {
    public static final String SAMPLE_TEXT = "A0B0a0b0ccc";

    @DisplayName("문자열과 자연수 unitCount가 주어질때 몫 문자열과 나머지 문자열 부분을 얻을 수 있다")
    @Test
    void normal() {
        final OutputUnit outputSet = new OutputUnit(SAMPLE_TEXT, 3);

        assertAll(
            () -> assertThat(outputSet.getQuotient()).isEqualTo("A0B0a0b0c"),
            () -> assertThat(outputSet.getRemainder()).isEqualTo("cc")
        );
    }

    @DisplayName("몫이 딱 떨어지는 경우 나머지는 empty이다")
    @Test
    void remainderEmpty() {
        final OutputUnit outputSet = new OutputUnit(SAMPLE_TEXT, SAMPLE_TEXT.length());

        assertAll(
            () -> assertThat(outputSet.getQuotient()).isEqualTo(SAMPLE_TEXT),
            () -> assertThat(outputSet.getRemainder()).isEmpty()
        );
    }

    @DisplayName("출력묶음단위로 나눠지지 않으면 몫은 empty이다")
    @Test
    void quotientEmpty() {
        final OutputUnit outputSet = new OutputUnit(SAMPLE_TEXT, SAMPLE_TEXT.length() + 1);

        assertAll(
            () -> assertThat(outputSet.getQuotient()).isEmpty(),
            () -> assertThat(outputSet.getRemainder()).isEqualTo(SAMPLE_TEXT)
        );
    }

    @DisplayName("targetString이 empty이면 몫과 나머지 모두 empty이다")
    @Test
    void allEmpty() {
        final OutputUnit outputSet = new OutputUnit("", 1);

        assertAll(
            () -> assertThat(outputSet.getQuotient()).isEmpty(),
            () -> assertThat(outputSet.getRemainder()).isEmpty()
        );
    }

    @DisplayName("unitCount가 0이면 ArithmeticException이 발생한다")
    @Test
    void devideZero() {
        assertThatThrownBy(() -> {
            new OutputUnit(SAMPLE_TEXT, 0);
        }).isInstanceOf(ArithmeticException.class);
    }
}
