package org.sohagroup.mobin.captiveportal.web.rest.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagroup.mobin.captiveportal.service.Interface.TokenService;
import org.sohagroup.mobin.captiveportal.web.rest.api.TokenApi;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.TokenModelRequest;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.TokenResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TokenResource implements TokenApi {

    private final TokenService tokenService;
    private final Logger logger = LoggerFactory.getLogger(TokenResource.class);

    public TokenResource(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public Mono<TokenResponseDTO> getToken(TokenModelRequest tokenModel) {
        logger.info("enter to getToken branches in TokenResource with TokenModelRequest:{}", tokenModel);
        return tokenService.getToken(tokenModel);
    }
}
