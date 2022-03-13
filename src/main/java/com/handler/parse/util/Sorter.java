package com.handler.parse.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class Sorter {

    private static final String EMPTY = "";

    public String sort(final String str) {
        return Arrays.stream(str.split(EMPTY))
            .sorted()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .collect(Collectors.joining());
    }

}
