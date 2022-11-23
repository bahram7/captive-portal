package org.sohagroup.mobin.captiveportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }
}
