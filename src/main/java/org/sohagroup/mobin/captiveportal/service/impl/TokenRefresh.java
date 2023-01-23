package org.sohagroup.mobin.captiveportal.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.TokenModelRequest;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TokenRefresh {

    private final Logger logger = LogManager.getLogger(TokenRefresh.class);
    private final RestTemplate restTemplate;

    //region configs
    @Value("${customTokenObtainPairRequestUsername}")
    private String userName;

    @Value("${customTokenObtainPairRequestPassword}")
    private String password;

    @Value("${token}")
    private String tokenUrl;

    private String accessToken;

    //endregion

    public TokenRefresh(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("ConstantConditions")
    @Scheduled(fixedDelay = 100000l)
    public void getToken() {
        logger.info("enter to getToken in TokenGenerator");
        try {
            TokenModelRequest tokenModel = new TokenModelRequest();
            tokenModel.setUserName(userName);
            tokenModel.setPassword(password);
            UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(tokenUrl);
            ResponseEntity<TokenResponseDTO> exchange = restTemplate.exchange(
                uri.toUriString(),
                HttpMethod.POST,
                new HttpEntity<>(tokenModel),
                TokenResponseDTO.class
            );
            logger.info("generated TokenRefresh : {}", exchange.getBody());
            accessToken = exchange.getBody().getAccess();
        } catch (Exception e) {
            logger.error("error : {}", e.getMessage(), e);
            throw e;
        }
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
