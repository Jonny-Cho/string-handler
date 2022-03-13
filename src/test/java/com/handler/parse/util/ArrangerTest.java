package com.handler.parse.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrangerTest {

    private final Arranger arranger = new Arranger(new Separator(), new Sorter());

    @DisplayName("String을 입력받으면 정렬된 영어 + 정렬된 숫자를 얻을 수 있다")
    @Test
    void normalCase() {
        final Arranger arrange = arranger.rearrange("e4C3dBA1aDf2cEAb0bF");
        assertAll(
            () -> assertThat(arrange.getSortedEnglish()).isEqualTo("AAaBbbCcDdEeFf"),
            () -> assertThat(arrange.getSortedNumber()).isEqualTo("01234")
        );
    }

    @DisplayName("String을 입력받을 때 숫자와 영어 이외의 값이 포함된 경우 지운다")
    @Test
    void removeSpecialChars() {
        final Arranger arrange = arranger.rearrange("e4C3AdB1<abDf2c!EA0@bF");
        assertAll(
            () -> assertThat(arrange.getSortedEnglish()).isEqualTo("AAaBbbCcDdEeFf"),
            () -> assertThat(arrange.getSortedNumber()).isEqualTo("01234")
        );
    }

}
