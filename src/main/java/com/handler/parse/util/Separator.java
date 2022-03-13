package com.handler.parse.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Separator {

    private final Pattern PATTERN = Pattern.compile("([A-Za-z]*)([0-9]*)");

    @Getter
    private String english;

    @Getter
    private String number;

    public Separator separate(final String str){
        final Matcher matcher = PATTERN.matcher(str);

        StringBuilder sbStr = new StringBuilder();
        StringBuilder sbNum = new StringBuilder();

        while (matcher.find()) {
            sbStr.append(matcher.group(1));
            sbNum.append(matcher.group(2));
        }

        this.english = sbStr.toString();
        this.number = sbNum.toString();
        return this;
    }

}
