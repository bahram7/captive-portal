package org.sohagroup.mobin.captiveportal.config;

import java.net.http.HttpClient;
import org.springframework.stereotype.Component;

@Component
public class HttpClientConfiguration {

    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }
}
