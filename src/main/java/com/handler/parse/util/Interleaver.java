package com.handler.parse.util;

import java.util.Arrays;
import java.util.Iterator;
import org.springframework.stereotype.Component;

@Component
public class Interleaver {

    private static final String DELIMITER = "";

    String interleave(final String str1, final String str2) {
        final StringBuilder sb = new StringBuilder();

        final Iterator<String> iterator1 = Arrays.stream(str1.split(DELIMITER)).iterator();
        final Iterator<String> iterator2 = Arrays.stream(str2.split(DELIMITER)).iterator();

        while (iterator1.hasNext() || iterator2.hasNext()) {
            if (iterator1.hasNext()) {
                sb.append(iterator1.next());
            }
            if (iterator2.hasNext()) {
                sb.append(iterator2.next());
            }
        }

        return sb.toString();
    }

    public String interleave(final Arranger arranger) {
        return interleave(arranger.getSortedEnglish(), arranger.getSortedNumber());
    }
}
