package com.handler.parse.util;

import com.handler.parse.error.UrlConnectionException;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

@Component
public class UrlConnector {

    public String getHtml(final String url) {
        try {
            return Jsoup.connect(url).get().html();
        } catch (IOException e) {
            throw new UrlConnectionException("접근할 수 없는 url입니다.");
        }
    }

}
